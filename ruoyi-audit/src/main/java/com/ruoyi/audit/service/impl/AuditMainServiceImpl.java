package com.ruoyi.audit.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.audit.mapper.AuditIssueMapper;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.audit.domain.AuditIssue;
import com.ruoyi.audit.mapper.AuditMainMapper;
import com.ruoyi.audit.domain.AuditMain;
import com.ruoyi.audit.service.IAuditMainService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 审计问题管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-25
 */
@Service
public class AuditMainServiceImpl extends ServiceImpl<AuditMainMapper, AuditMain> implements IAuditMainService
{
    @Autowired
    private AuditMainMapper auditMainMapper;

    /**
     * 查询审计问题管理
     * 
     * @param id 审计问题管理主键
     * @return 审计问题管理
     */
    @Override
    public AuditMain selectAuditMainById(Long id)
    {
        return auditMainMapper.selectAuditMainById(id);
    }

    /**
     * 查询审计问题管理列表
     * 
     * @param auditMain 审计问题管理
     * @return 审计问题管理
     */
    @Override
    public List<AuditMain> selectAuditMainList(AuditMain auditMain)
    {
        return auditMainMapper.selectAuditMainList(auditMain);
    }

    /**
     * 新增审计问题管理
     * 
     * @param auditMain 审计问题管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertAuditMain(AuditMain auditMain)
    {
        auditMain.setCreatedBy(SecurityUtils.getUserId());
        int rows = auditMainMapper.insertAuditMain(auditMain);
        //insertAuditIssue(auditMain);
        return rows;
    }

    /**
     * 修改审计问题管理
     * 
     * @param auditMain 审计问题管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateAuditMain(AuditMain auditMain)
    {
        auditMain.setUpdatedBy(SecurityUtils.getUserId());
        auditMainMapper.deleteAuditIssueByAuditMainId(auditMain.getId());
        //insertAuditIssue(auditMain);
        return auditMainMapper.updateAuditMain(auditMain);
    }

    /**
     * 批量删除审计问题管理
     * 
     * @param ids 需要删除的审计问题管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAuditMainByIds(Long[] ids)
    {
        auditMainMapper.deleteAuditIssueByAuditMainIds(ids);
        return auditMainMapper.deleteAuditMainByIds(ids);
    }

    /**
     * 删除审计问题管理信息
     * 
     * @param id 审计问题管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAuditMainById(Long id)
    {
        auditMainMapper.deleteAuditIssueByAuditMainId(id);
        return auditMainMapper.deleteAuditMainById(id);
    }

    /**
     * 新增审计问题子信息
     * 
     * @param auditMain 审计问题管理对象
     */
/*    public void insertAuditIssue(AuditMain auditMain)
    {
        List<AuditIssue> auditIssueList = auditMain.getAuditIssueList();
        Long id = auditMain.getId();
        if (StringUtils.isNotNull(auditIssueList))
        {
            List<AuditIssue> list = new ArrayList<AuditIssue>();
            for (AuditIssue auditIssue : auditIssueList)
            {
                auditIssue.setAuditMainId(id);
                list.add(auditIssue);
            }
            if (list.size() > 0)
            {
                auditMainMapper.batchAuditIssue(list);
            }
        }
    }*/
}
