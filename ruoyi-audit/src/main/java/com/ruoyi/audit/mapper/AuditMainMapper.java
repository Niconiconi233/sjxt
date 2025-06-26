package com.ruoyi.audit.mapper;

import java.util.List;
import com.ruoyi.audit.domain.AuditMain;
import com.ruoyi.audit.domain.AuditIssue;

/**
 * 审计问题管理Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-25
 */
public interface AuditMainMapper 
{
    /**
     * 查询审计问题管理
     * 
     * @param id 审计问题管理主键
     * @return 审计问题管理
     */
    public AuditMain selectAuditMainById(Long id);

    /**
     * 查询审计问题管理列表
     * 
     * @param auditMain 审计问题管理
     * @return 审计问题管理集合
     */
    public List<AuditMain> selectAuditMainList(AuditMain auditMain);

    /**
     * 新增审计问题管理
     * 
     * @param auditMain 审计问题管理
     * @return 结果
     */
    public int insertAuditMain(AuditMain auditMain);

    /**
     * 修改审计问题管理
     * 
     * @param auditMain 审计问题管理
     * @return 结果
     */
    public int updateAuditMain(AuditMain auditMain);

    /**
     * 删除审计问题管理
     * 
     * @param id 审计问题管理主键
     * @return 结果
     */
    public int deleteAuditMainById(Long id);

    /**
     * 批量删除审计问题管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAuditMainByIds(Long[] ids);

    /**
     * 批量删除审计问题子
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAuditIssueByAuditMainIds(Long[] ids);
    
    /**
     * 批量新增审计问题子
     * 
     * @param auditIssueList 审计问题子列表
     * @return 结果
     */
    public int batchAuditIssue(List<AuditIssue> auditIssueList);
    

    /**
     * 通过审计问题管理主键删除审计问题子信息
     * 
     * @param id 审计问题管理ID
     * @return 结果
     */
    public int deleteAuditIssueByAuditMainId(Long id);
}
