package com.ruoyi.esearch.domain;

import com.ruoyi.esearch.DTO.RegulationDTO;
import lombok.Data;
import org.dromara.easyes.annotation.HighLight;
import org.dromara.easyes.annotation.IndexField;
import org.dromara.easyes.annotation.IndexId;
import org.dromara.easyes.annotation.IndexName;
import org.dromara.easyes.annotation.rely.Analyzer;
import org.dromara.easyes.annotation.rely.FieldType;
import org.dromara.easyes.annotation.rely.IdType;

import java.util.Date;

/**
 * 包名：com.ruoyi.esearch.domain
 * 版权：Copyright by yw
 * 描述：
 * 修改人：yw
 * 修改时间：2025-06-04 22:09
 **/
@Data
@IndexName
public class Regulation {

    @IndexId(type = IdType.NONE)
    private String id;

    @HighLight(preTag = "<em style='color:red'>", postTag = "</em>")
    @IndexField(fieldType = FieldType.TEXT, analyzer = Analyzer.IK_SMART, searchAnalyzer = Analyzer.IK_MAX_WORD)
    private String regulationName;

    @IndexField(fieldType = FieldType.KEYWORD, fieldData = true)
    private String regulationUrl;

    @IndexField(fieldType = FieldType.TEXT)
    private String regulationContext;

    @IndexField("attachment")
    private Attachment attachment;

    public RegulationDTO toDTO() {
        RegulationDTO regulationDTO = new RegulationDTO();
        regulationDTO.setId(this.id);
        regulationDTO.setRegulationName(this.regulationName);
        regulationDTO.setRegulationUrl(this.regulationUrl);
        regulationDTO.setRegulationContext(this.regulationContext);
        return regulationDTO;
    }
}

