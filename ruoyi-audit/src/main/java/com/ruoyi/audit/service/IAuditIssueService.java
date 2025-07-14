package com.ruoyi.audit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.audit.domain.AuditIssue;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 包名：com.ruoyi.audit.service
 * 版权：Copyright by yw
 * 描述：
 * 修改人：yw
 * 修改时间：2025-07-14 22:43
 **/
public interface IAuditIssueService extends IService<AuditIssue> {

    /**
     * 导入问题细项
     *
     * @param file 上传的excel文件
     * @return 结果
     */
    public Integer importAuditIssue(MultipartFile file, Long id) throws IOException;

}
