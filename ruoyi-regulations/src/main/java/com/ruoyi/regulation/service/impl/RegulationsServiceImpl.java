package com.ruoyi.regulation.service.impl;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.UriEncoder;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.sign.Base64;
import com.ruoyi.esearch.domain.Regulation;
import com.ruoyi.esearch.mapper.EsRegulationMapper;
import com.ruoyi.regulation.domain.Regulations;
import com.ruoyi.regulation.mapper.RegulationsMapper;
import com.ruoyi.regulation.service.IRegulationsService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 制度管理Service业务层处理
 * 
 * @author yw
 * @date 2025-05-28
 */
@Service
public class RegulationsServiceImpl implements IRegulationsService 
{
    @Autowired
    private RegulationsMapper regulationsMapper;

    @Resource
    private EsRegulationMapper regulationMapper;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 查询制度管理
     * 
     * @param id 制度管理主键
     * @return 制度管理
     */
    @Override
    public Regulations selectRegulationsById(Long id)
    {
        return regulationsMapper.selectRegulationsById(id);
    }

    /**
     * 查询制度管理列表
     * 
     * @param regulations 制度管理
     * @return 制度管理
     */
    @Override
    public List<Regulations> selectRegulationsList(Regulations regulations)
    {
        return regulationsMapper.selectRegulationsList(regulations);
    }

    /**
     * 新增制度管理
     * 
     * @param regulations 制度管理
     * @return 结果
     */
    @Override
    public int insertRegulations(Regulations regulations) throws UnsupportedEncodingException {
        regulations.setCreateTime(DateUtils.getNowDate());
        regulations.setCreateBy(SecurityUtils.getUserId().toString());
        regulations.setParseStatus(2);
        regulations.setRegulationUrlEncoded(UriEncoder.encodeChineseInUrl(regulations.getRegulationUrl()));
        return regulationsMapper.insertRegulations(regulations);
    }

    /**
     * 修改制度管理
     * 
     * @param regulations 制度管理
     * @return 结果
     */
    @Override
    public int updateRegulations(Regulations regulations)
    {
        regulations.setModifyTime(DateUtils.getNowDate());
        return regulationsMapper.updateRegulations(regulations);
    }

    /**
     * 批量删除制度管理
     * 
     * @param ids 需要删除的制度管理主键
     * @return 结果
     */
    @Override
    public int deleteRegulationsByIds(Long[] ids)
    {
        return regulationsMapper.deleteRegulationsByIds(ids);
    }

    /**
     * 删除制度管理信息
     * 
     * @param id 制度管理主键
     * @return 结果
     */
    @Override
    public int deleteRegulationsById(Long id)
    {
        return regulationsMapper.deleteRegulationsById(id);
    }


    @Override
    public int parseRegulation(Long id) throws IOException {

        Regulations regulations = regulationsMapper.selectRegulationsById(id);
        if (regulations.getParseStatus() == 1) {
            return 1;
        }
        String encodedUrl = regulations.getRegulationUrlEncoded();
        if (StringUtils.isEmpty(encodedUrl)) {
            return -1;
        }else {

            String extension = FileUtils.getFilenameExtend(encodedUrl);
            if (!StringUtils.isEmpty(extension)) {
                extension = extension.toUpperCase();
                switch (extension) {
                    case "PDF":
                        putPDFtoEs(regulations.getRegulationUrlEncoded(), regulations.getRegulationName());
                        regulations.setParseStatus(1);
                        regulationsMapper.updateRegulations(regulations);
                        return 1;
                    default:
                        return -1;
                }
            }
        }
        return -1;
    }


    private void putPDFtoEs(String PDFUrl, String PDFName) throws IOException {
        InputStream ipt = FileUtils.getDownloadInputStreamByUrl(PDFUrl);
        String base64 = Base64.inputStreamToBase64(ipt);
        Regulation regulation = new Regulation();
        regulation.setRegulationName(PDFName);
        regulation.setRegulationUrl(PDFUrl);
        regulation.setRegulationContext(base64);
        String body = JSON.toJSONString(regulation);
        IndexRequest indexRequest = new IndexRequest().index("regulation")
                .source(body, XContentType.JSON)
                .setPipeline("attachment")
                .timeout(TimeValue.timeValueMillis(20));
        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
    }
}
