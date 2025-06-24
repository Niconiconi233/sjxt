package com.ruoyi.web.controller.regulations;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.regulation.domain.RegulationsId;
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
import com.ruoyi.regulation.domain.Regulations;
import com.ruoyi.regulation.service.IRegulationsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 制度管理Controller
 * 
 * @author yw
 * @date 2025-05-28
 */
@RestController
@RequestMapping("/regulation/regulations")
public class RegulationsController extends BaseController
{
    @Autowired
    private IRegulationsService regulationsService;

    /**
     * 查询制度管理列表
     */
    @PreAuthorize("@ss.hasPermi('regulation:regulations:list')")
    @GetMapping("/list")
    public TableDataInfo list(Regulations regulations)
    {
        startPage();
        List<Regulations> list = regulationsService.selectRegulationsList(regulations);
        return getDataTable(list);
    }

    /**
     * 导出制度管理列表
     */
    @PreAuthorize("@ss.hasPermi('regulation:regulations:export')")
    @Log(title = "制度管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Regulations regulations)
    {
        List<Regulations> list = regulationsService.selectRegulationsList(regulations);
        ExcelUtil<Regulations> util = new ExcelUtil<Regulations>(Regulations.class);
        util.exportExcel(response, list, "制度管理数据");
    }

    /**
     * 获取制度管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('regulation:regulations:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(regulationsService.selectRegulationsById(id));
    }

    /**
     * 新增制度管理
     */
    @PreAuthorize("@ss.hasPermi('regulation:regulations:add')")
    @Log(title = "制度管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Regulations regulations) throws UnsupportedEncodingException {
        return toAjax(regulationsService.insertRegulations(regulations));
    }

    /**
     * 修改制度管理
     */
    @PreAuthorize("@ss.hasPermi('regulation:regulations:edit')")
    @Log(title = "制度管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Regulations regulations)
    {
        return toAjax(regulationsService.updateRegulations(regulations));
    }

    /**
     * 删除制度管理
     */
    @PreAuthorize("@ss.hasPermi('regulation:regulations:remove')")
    @Log(title = "制度管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(regulationsService.deleteRegulationsByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('regulation:regulations:parse')")
    @Log(title = "制度管理", businessType = BusinessType.UPDATE)
    @PostMapping("/parse")
    public AjaxResult parse(@RequestBody RegulationsId regulationsId) throws IOException {
        int i = regulationsService.parseRegulation(regulationsId.getId());
        if (i == -1) {
            return error("制度解析失败");
        }else {
            return success("解析成功");
        }
    }
}
