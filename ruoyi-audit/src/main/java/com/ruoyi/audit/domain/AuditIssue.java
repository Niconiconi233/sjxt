package com.ruoyi.audit.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审计问题子对象 audit_issue
 * 
 * @author ruoyi
 * @date 2025-06-25
 */
public class AuditIssue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 关联的审计项目ID */
    private Long auditMainId;

    /** 问题定性（如：合规性问题、财务问题等） */
    @Excel(name = "问题定性", readConverterExp = "如=：合规性问题、财务问题等")
    private String issueType;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String issueDescription;

    /** 整改状态 */
    @Excel(name = "整改状态")
    private String issueStatus;

    /** 整改截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "整改截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /** 整改措施 */
    @Excel(name = "整改措施")
    private String rectificationMeasure;

    /** 整改结果 */
    @Excel(name = "整改结果")
    private String rectificationResult;

    /** 整改支撑材料路径（JSON数组） */
    @Excel(name = "整改支撑材料路径", readConverterExp = "J=SON数组")
    private String supportMaterials;

    /** 创建时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;

    /** 逻辑删除标志（0=未删除，1=已删除） */
    private Integer isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAuditMainId(Long auditMainId) 
    {
        this.auditMainId = auditMainId;
    }

    public Long getAuditMainId() 
    {
        return auditMainId;
    }
    public void setIssueType(String issueType) 
    {
        this.issueType = issueType;
    }

    public String getIssueType() 
    {
        return issueType;
    }
    public void setIssueDescription(String issueDescription) 
    {
        this.issueDescription = issueDescription;
    }

    public String getIssueDescription() 
    {
        return issueDescription;
    }
    public void setIssueStatus(String issueStatus) 
    {
        this.issueStatus = issueStatus;
    }

    public String getIssueStatus() 
    {
        return issueStatus;
    }
    public void setDueDate(Date dueDate) 
    {
        this.dueDate = dueDate;
    }

    public Date getDueDate() 
    {
        return dueDate;
    }
    public void setRectificationMeasure(String rectificationMeasure) 
    {
        this.rectificationMeasure = rectificationMeasure;
    }

    public String getRectificationMeasure() 
    {
        return rectificationMeasure;
    }
    public void setRectificationResult(String rectificationResult) 
    {
        this.rectificationResult = rectificationResult;
    }

    public String getRectificationResult() 
    {
        return rectificationResult;
    }
    public void setSupportMaterials(String supportMaterials) 
    {
        this.supportMaterials = supportMaterials;
    }

    public String getSupportMaterials() 
    {
        return supportMaterials;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("auditMainId", getAuditMainId())
            .append("issueType", getIssueType())
            .append("issueDescription", getIssueDescription())
            .append("issueStatus", getIssueStatus())
            .append("dueDate", getDueDate())
            .append("rectificationMeasure", getRectificationMeasure())
            .append("rectificationResult", getRectificationResult())
            .append("supportMaterials", getSupportMaterials())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
