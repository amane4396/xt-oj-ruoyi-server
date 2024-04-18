package com.ruoyi.web.controller.oj;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.system.domain.OjClass;
import com.ruoyi.system.service.IOjClassService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班级管理Controller
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@RestController
@RequestMapping("/system/class")
public class OjClassController extends BaseController {
    @Autowired
    private IOjClassService ojClassService;

    /**
     * 查询班级管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(OjClass ojClass) {
        startPage();
        List<OjClass> list = ojClassService.selectOjClassList(ojClass);
        return getDataTable(list);
    }

    @GetMapping("/listAllClass")
    public List<OjClass>  listAllClass(OjClass ojClass) {
        return ojClassService.selectOjClassList(ojClass);
    }

    /**
     * 导出班级管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:class:export')")
    @Log(title = "班级管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OjClass ojClass) {
        List<OjClass> list = ojClassService.selectOjClassList(ojClass);
        ExcelUtil<OjClass> util = new ExcelUtil<OjClass>(OjClass.class);
        util.exportExcel(response, list, "班级管理数据");
    }

    /**
     * 获取班级管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:class:query')")
    @GetMapping(value = "/{classId}")
    public AjaxResult getInfo(@PathVariable("classId") Long classId) {
        return success(ojClassService.selectOjClassByClassId(classId));
    }

    /**
     * 新增班级管理
     */
    @PreAuthorize("@ss.hasPermi('system:class:add')")
    @Log(title = "班级管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OjClass ojClass) {
        return toAjax(ojClassService.insertOjClass(ojClass));
    }

    /**
     * 修改班级管理
     */
    @PreAuthorize("@ss.hasPermi('system:class:edit')")
    @Log(title = "班级管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjClass ojClass) {
        return toAjax(ojClassService.updateOjClass(ojClass));
    }

    /**
     * 删除班级管理
     */
    @PreAuthorize("@ss.hasPermi('system:class:remove')")
    @Log(title = "班级管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{classIds}")
    public AjaxResult remove(@PathVariable Long[] classIds) {
        return toAjax(ojClassService.deleteOjClassByClassIds(classIds));
    }
}
