package com.ruoyi.esearch.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.esearch.domain.Regulation;
import com.ruoyi.esearch.mapper.EsRegulationMapper;
import com.ruoyi.esearch.service.EsRegulationService;
import org.dromara.easyes.core.conditions.select.LambdaEsQueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 包名：com.ruoyi.esearch.service.impl
 * 版权：Copyright by yw
 * 描述：
 * 修改人：yw
 * 修改时间：2025-06-23 22:40
 **/
@Service
public class EsRegulationServiceImpl implements EsRegulationService {

    @Resource
    private EsRegulationMapper regulationMapper;

    @Override
    public List<Regulation> searchRegulationByKeyword(String type, String key_word) {
        if (StringUtils.isEmpty(type)) {
            return new ArrayList<>();
        }
        LambdaEsQueryWrapper<Regulation> wrapper = new LambdaEsQueryWrapper<>();
        if (key_word.isEmpty()) {
            wrapper.matchAllQuery();
        }else if (type.equals("name")) {
            wrapper.match(Regulation::getRegulationName, key_word);
        }else {
            wrapper.match(Regulation::getRegulationContext, key_word);
        }
        return regulationMapper.selectList(wrapper);
    }
}
