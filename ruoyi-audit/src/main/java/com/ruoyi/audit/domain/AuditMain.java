package com.ruoyi.audit.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 审计问题管理对象 audit_main
 * 
 * @author ruoyi
 * @date 2025-06-25
 */
public class AuditMain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @Excel(name = "主键ID")
    private Long id;

    /** 审计项目名称 */
    @Excel(name = "审计项目名称")
    private String projectName;

    /** 录入人名称 */
    @Excel(name = "录入人名称")
    private String inputBy;

    /** 录入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "录入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inputDate;

    /** 整体整改时限 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "整体整改时限", width = 30, dateFormat = "yyyy-MM-dd")
    private Date rectificationDeadline;

    /** 逻辑删除标志（0=未删除，1=已删除） */
    private Integer isDeleted;

    /** 整改机构ID */
    private Long rectificationOrgId;

    /** 整改机构名字 */
    @Excel(name = "整改机构名字")
    private String rectificationOrgName;

    /** 问题个数 */
    private Integer issueCount;

    /** 问题笔数 */
    private Integer issueNum;

    /** 问题金额 */
    private Double issueAmount;

    /** 整改问题个数 */
    private Integer rectifiedIssueCount;

    /** 整改问题笔数 */
    private Integer rectifiedIssueNum;

    /** 整改问题金额 */
    private Double rectifiedIssueAmount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }

    public void setInputBy(String inputBy) 
    {
        this.inputBy = inputBy;
    }

    public String getInputBy() 
    {
        return inputBy;
    }

    public void setInputDate(Date inputDate) 
    {
        this.inputDate = inputDate;
    }

    public Date getInputDate() 
    {
        return inputDate;
    }

    public void setRectificationDeadline(Date rectificationDeadline) 
    {
        this.rectificationDeadline = rectificationDeadline;
    }

    public Date getRectificationDeadline() 
    {
        return rectificationDeadline;
    }

    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }

    public void setRectificationOrgId(Long rectificationOrgId) 
    {
        this.rectificationOrgId = rectificationOrgId;
    }

    public Long getRectificationOrgId() 
    {
        return rectificationOrgId;
    }

    public void setRectificationOrgName(String rectificationOrgName) 
    {
        this.rectificationOrgName = rectificationOrgName;
    }

    public String getRectificationOrgName() 
    {
        return rectificationOrgName;
    }

    public Double getIssueAmount() {
        return issueAmount;
    }

    public Double getRectifiedIssueAmount() {
        return rectifiedIssueAmount;
    }

    public Integer getIssueCount() {
        return issueCount;
    }

    public Integer getIssueNum() {
        return issueNum;
    }

    public Integer getRectifiedIssueCount() {
        return rectifiedIssueCount;
    }

    public Integer getRectifiedIssueNum() {
        return rectifiedIssueNum;
    }

    public void setIssueAmount(Double issueAmount) {
        this.issueAmount = issueAmount;
    }

    public void setIssueCount(Integer issueCount) {
        this.issueCount = issueCount;
    }

    public void setIssueNum(Integer issueNum) {
        this.issueNum = issueNum;
    }

    public void setRectifiedIssueAmount(Double rectifiedIssueAmount) {
        this.rectifiedIssueAmount = rectifiedIssueAmount;
    }

    public void setRectifiedIssueCount(Integer rectifiedIssueCount) {
        this.rectifiedIssueCount = rectifiedIssueCount;
    }

    public void setRectifiedIssueNum(Integer rectifiedIssueNum) {
        this.rectifiedIssueNum = rectifiedIssueNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectName", getProjectName())
            .append("inputBy", getInputBy())
            .append("inputDate", getInputDate())
            .append("rectificationDeadline", getRectificationDeadline())
            .append("isDeleted", getIsDeleted())
            .append("rectificationOrgId", getRectificationOrgId())
            .append("rectificationOrgName", getRectificationOrgName())
            .toString();
    }
}
