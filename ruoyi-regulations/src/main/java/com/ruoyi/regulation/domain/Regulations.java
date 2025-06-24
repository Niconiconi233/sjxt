package com.ruoyi.regulation.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 制度管理对象 regulations
 * 
 * @author yw
 * @date 2025-05-28
 */
public class Regulations extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "制度名称", readConverterExp = "$column.readConverterExp()")
    private String regulationName;

    /** $column.columnComment */
    @Excel(name = "制度编号", readConverterExp = "$column.readConverterExp()")
    private String regulationNo;

    /** $column.columnComment */
    @Excel(name = "制度地址", readConverterExp = "$column.readConverterExp()")
    private String regulationUrl;

    @Excel(name = "制度地址编码", readConverterExp = "$column.readConverterExp()")
    private String regulationUrlEncoded;
    /** $column.columnComment */
    @Excel(name = "制度状态", readConverterExp = "$column.readConverterExp()")
    private Long regulationStatus;

    @Excel(name = "创建时间", readConverterExp = "$column.readConverterExp()")
    private Date createTime;
    /** $column.columnComment */
    @Excel(name = "修改时间", readConverterExp = "$column.readConverterExp()")
    private Date modifyTime;

    @Excel(name = "解析状态", readConverterExp = "$column.readConverterExp()")
    private Integer parseStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setRegulationName(String regulationName) 
    {
        this.regulationName = regulationName;
    }

    public String getRegulationName() 
    {
        return regulationName;
    }

    public void setRegulationNo(String regulationNo) 
    {
        this.regulationNo = regulationNo;
    }

    public String getRegulationNo() 
    {
        return regulationNo;
    }

    public void setRegulationUrl(String regulationUrl) 
    {
        this.regulationUrl = regulationUrl;
    }

    public String getRegulationUrl() 
    {
        return regulationUrl;
    }

    public void setRegulationStatus(Long regulationStatus) 
    {
        this.regulationStatus = regulationStatus;
    }

    public Long getRegulationStatus() 
    {
        return regulationStatus;
    }

    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }

    public Integer getParseStatus() {
        return parseStatus;
    }

    public void setParseStatus(Integer parseStatus) {
        this.parseStatus = parseStatus;
    }

    public String getRegulationUrlEncoded() {
        return regulationUrlEncoded;
    }

    public void setRegulationUrlEncoded(String regulationUrlEncoded) {
        this.regulationUrlEncoded = regulationUrlEncoded;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("regulationName", getRegulationName())
            .append("regulationNo", getRegulationNo())
            .append("regulationUrl", getRegulationUrl())
            .append("regulationStatus", getRegulationStatus())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .append("createBy", getCreateBy())
            .toString();
    }
}
