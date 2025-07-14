package com.ruoyi.audit.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.audit.domain.AuditIssue;
import com.ruoyi.audit.mapper.AuditIssueMapper;
import com.ruoyi.audit.service.IAuditIssueService;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 包名：com.ruoyi.audit.service.impl
 * 版权：Copyright by yw
 * 描述：
 * 修改人：yw
 * 修改时间：2025-07-14 22:43
 **/
@Service
public class AuditIssueServiceImpl extends ServiceImpl<AuditIssueMapper, AuditIssue> implements IAuditIssueService {

    @Override
    @Transactional
    public Integer importAuditIssue(MultipartFile file, Long id) throws IOException {
        ExcelUtil<AuditIssue> auditIssueExcelUtil = new ExcelUtil<AuditIssue>(AuditIssue.class);
        List<AuditIssue> auditIssues = auditIssueExcelUtil.importExcel(file.getInputStream());
        for (AuditIssue auditIssue : auditIssues) {
            auditIssue.setAuditMainId(id);
            auditIssue.setIsDeleted(0);
            auditIssue.setCreateBy(SecurityUtils.getUserId().toString());
            auditIssue.setCreateTime(new Date());
        }
        boolean result = saveBatch(auditIssues);
        if (result) {
            return auditIssues.size();
        }else {
            return -1;
        }
    }
}
