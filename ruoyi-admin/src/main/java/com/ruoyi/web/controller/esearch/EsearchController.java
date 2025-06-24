package com.ruoyi.web.controller.esearch;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.esearch.domain.Regulation;
import com.ruoyi.esearch.service.EsRegulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 包名：com.ruoyi.web.controller.esearch
 * 版权：Copyright by yw
 * 描述：
 * 修改人：yw
 * 修改时间：2025-06-04 22:18
 **/
@RestController
@RequestMapping("/regulation/search")
public class EsearchController extends BaseController {

    @Autowired
    private EsRegulationService esRegulationService;


    @Anonymous
    @GetMapping("search")
    public AjaxResult search(@RequestParam String type, @RequestParam String key_word) {
        List<Regulation> regulations = esRegulationService.searchRegulationByKeyword(type, key_word);
        return success(regulations);
    }


    @Anonymous
    @GetMapping("/testget")
    public AjaxResult testGet() {
        return success("test");
    }



























}
