package com.ruoyi.esearch.service;

import com.ruoyi.esearch.DTO.RegulationDTO;
import com.ruoyi.esearch.domain.Regulation;

import java.util.List;

/**
 * 包名：com.ruoyi.esearch.service
 * 版权：Copyright by yw
 * 描述：
 * 修改人：yw
 * 修改时间：2025-06-23 22:40
 **/
public interface EsRegulationService {

    public List<RegulationDTO> searchRegulationByKeyword(String type, String key_word);
}
