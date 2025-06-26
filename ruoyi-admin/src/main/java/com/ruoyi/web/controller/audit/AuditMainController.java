package com.ruoyi.web.controller.audit;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.audit.domain.AuditMain;
import com.ruoyi.audit.service.IAuditMainService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 审计问题管理Controller
 * 
 * @author ruoyi
 * @date 2025-06-25
 */
@RestController
@RequestMapping("/audit/audit")
public class AuditMainController extends BaseController
{
    @Autowired
    private IAuditMainService auditMainService;

    /**
     * 查询审计问题管理列表
     */
    @PreAuthorize("@ss.hasPermi('audit:audit:list')")
    @GetMapping("/list")
    public TableDataInfo list(AuditMain auditMain)
    {
        startPage();
        List<AuditMain> list = auditMainService.selectAuditMainList(auditMain);
        return getDataTable(list);
    }

    /**
     * 导出审计问题管理列表
     */
    @PreAuthorize("@ss.hasPermi('audit:audit:export')")
    @Log(title = "审计问题管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AuditMain auditMain)
    {
        List<AuditMain> list = auditMainService.selectAuditMainList(auditMain);
        ExcelUtil<AuditMain> util = new ExcelUtil<AuditMain>(AuditMain.class);
        util.exportExcel(response, list, "审计问题管理数据");
    }

    /**
     * 获取审计问题管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('audit:audit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(auditMainService.selectAuditMainById(id));
    }

    /**
     * 新增审计问题管理
     */
    @PreAuthorize("@ss.hasPermi('audit:audit:add')")
    @Log(title = "审计问题管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AuditMain auditMain)
    {
        return toAjax(auditMainService.insertAuditMain(auditMain));
    }

    /**
     * 修改审计问题管理
     */
    @PreAuthorize("@ss.hasPermi('audit:audit:edit')")
    @Log(title = "审计问题管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AuditMain auditMain)
    {
        return toAjax(auditMainService.updateAuditMain(auditMain));
    }

    /**
     * 删除审计问题管理
     */
    @PreAuthorize("@ss.hasPermi('audit:audit:remove')")
    @Log(title = "审计问题管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(auditMainService.deleteAuditMainByIds(ids));
    }
}
