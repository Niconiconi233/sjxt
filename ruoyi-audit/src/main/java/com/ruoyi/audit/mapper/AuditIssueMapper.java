package com.ruoyi.audit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.audit.domain.AuditIssue;

import java.util.List;

/**
 * 包名：com.ruoyi.audit.mapper
 * 版权：Copyright by yw
 * 描述：
 * 修改人：yw
 * 修改时间：2025-07-14 22:41
 **/
public interface AuditIssueMapper extends BaseMapper<AuditIssue> {

    /**
     * 批量新增审计问题子
     *
     * @param auditIssueList 审计问题子列表
     * @return 结果
     */
    public int batchAuditIssue(List<AuditIssue> auditIssueList);
}
