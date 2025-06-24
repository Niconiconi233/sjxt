package com.ruoyi.regulation.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import com.ruoyi.regulation.domain.Regulations;

/**
 * 制度管理Service接口
 * 
 * @author yw
 * @date 2025-05-28
 */
public interface IRegulationsService 
{
    /**
     * 查询制度管理
     * 
     * @param id 制度管理主键
     * @return 制度管理
     */
    public Regulations selectRegulationsById(Long id);

    /**
     * 查询制度管理列表
     * 
     * @param regulations 制度管理
     * @return 制度管理集合
     */
    public List<Regulations> selectRegulationsList(Regulations regulations);

    /**
     * 新增制度管理
     * 
     * @param regulations 制度管理
     * @return 结果
     */
    public int insertRegulations(Regulations regulations) throws UnsupportedEncodingException;

    /**
     * 修改制度管理
     * 
     * @param regulations 制度管理
     * @return 结果
     */
    public int updateRegulations(Regulations regulations);

    /**
     * 批量删除制度管理
     * 
     * @param ids 需要删除的制度管理主键集合
     * @return 结果
     */
    public int deleteRegulationsByIds(Long[] ids);

    /**
     * 删除制度管理信息
     * 
     * @param id 制度管理主键
     * @return 结果
     */
    public int deleteRegulationsById(Long id);


    /**
     * 对单个制度进行解析
     *
     * @param id 制度管理主键
     * @return 结果
     */
    public int parseRegulation(Long id) throws IOException;
}
