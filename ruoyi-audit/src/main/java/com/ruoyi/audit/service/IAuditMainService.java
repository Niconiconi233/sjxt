package com.ruoyi.audit.service;

import java.util.List;
import com.ruoyi.audit.domain.AuditMain;

/**
 * 审计问题管理Service接口
 * 
 * @author ruoyi
 * @date 2025-06-25
 */
public interface IAuditMainService 
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
     * 批量删除审计问题管理
     * 
     * @param ids 需要删除的审计问题管理主键集合
     * @return 结果
     */
    public int deleteAuditMainByIds(Long[] ids);

    /**
     * 删除审计问题管理信息
     * 
     * @param id 审计问题管理主键
     * @return 结果
     */
    public int deleteAuditMainById(Long id);
}
