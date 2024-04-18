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
import com.ruoyi.system.domain.OjCase;
import com.ruoyi.system.service.IOjCaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 题目样例Controller
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@RestController
@RequestMapping("/system/case")
public class OjCaseController extends BaseController {
    @Autowired
    private IOjCaseService ojCaseService;

    /**
     * 查询题目样例列表
     */
    @PreAuthorize("@ss.hasPermi('system:case:list')")
    @GetMapping("/list")
    public TableDataInfo list(OjCase ojCase) {
        startPage();
        List<OjCase> list = ojCaseService.selectOjCaseList(ojCase);
        return getDataTable(list);
    }

    /**
     * 导出题目样例列表
     */
    @PreAuthorize("@ss.hasPermi('system:case:export')")
    @Log(title = "题目样例", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OjCase ojCase) {
        List<OjCase> list = ojCaseService.selectOjCaseList(ojCase);
        ExcelUtil<OjCase> util = new ExcelUtil<OjCase>(OjCase.class);
        util.exportExcel(response, list, "题目样例数据");
    }

    /**
     * 获取题目样例详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:case:query')")
    @GetMapping(value = "/{caseId}")
    public AjaxResult getInfo(@PathVariable("caseId") Long caseId) {
        return success(ojCaseService.selectOjCaseByCaseId(caseId));
    }

    /**
     * 新增题目样例
     */
    @PreAuthorize("@ss.hasPermi('system:case:add')")
    @Log(title = "题目样例", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OjCase ojCase) {
        return toAjax(ojCaseService.insertOjCase(ojCase));
    }

    /**
     * 修改题目样例
     */
    @PreAuthorize("@ss.hasPermi('system:case:edit')")
    @Log(title = "题目样例", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjCase ojCase) {
        return toAjax(ojCaseService.updateOjCase(ojCase));
    }

    /**
     * 删除题目样例
     */
    @PreAuthorize("@ss.hasPermi('system:case:remove')")
    @Log(title = "题目样例", businessType = BusinessType.DELETE)
    @DeleteMapping("/{caseIds}")
    public AjaxResult remove(@PathVariable Long[] caseIds) {
        return toAjax(ojCaseService.deleteOjCaseByCaseIds(caseIds));
    }
}
