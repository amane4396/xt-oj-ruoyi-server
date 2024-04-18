package com.ruoyi.web.controller.oj;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
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
import com.ruoyi.system.domain.OjQuestion;
import com.ruoyi.system.service.IOjQuestionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 题目管理Controller
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@RestController
@RequestMapping("/system/question")
public class OjQuestionController extends BaseController {
    @Autowired
    private IOjQuestionService ojQuestionService;


    /**
     * 查询题目管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:list')")
    @GetMapping("/list")
    public TableDataInfo list(OjQuestion ojQuestion) {
        startPage();
        List<OjQuestion> list = ojQuestionService.selectOjQuestionList(ojQuestion);
        return getDataTable(list);
    }

    /**
     * 查询题目管理列表
     */
    @GetMapping("/listAllQuestion")
    public List<OjQuestion> listAllQuestion(OjQuestion ojQuestion) {
        return ojQuestionService.selectOjQuestionList(ojQuestion);
    }

    /**
     * 导出题目管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:question:export')")
    @Log(title = "题目管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OjQuestion ojQuestion) {
        List<OjQuestion> list = ojQuestionService.selectOjQuestionList(ojQuestion);
        ExcelUtil<OjQuestion> util = new ExcelUtil<OjQuestion>(OjQuestion.class);
        util.exportExcel(response, list, "题目管理数据");
    }

    /**
     * 获取题目管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:question:query')")
    @GetMapping(value = "/{questionId}")
    public AjaxResult getInfo(@PathVariable("questionId") Long questionId) {
        return success(ojQuestionService.selectOjQuestionByQuestionId(questionId));
    }

    /**
     * 新增题目管理
     */
    @PreAuthorize("@ss.hasPermi('system:question:add')")
    @Log(title = "题目管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OjQuestion ojQuestion) {
        return toAjax(ojQuestionService.insertOjQuestion(ojQuestion));
    }

    /**
     * 修改题目管理
     */
    @PreAuthorize("@ss.hasPermi('system:question:edit')")
    @Log(title = "题目管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjQuestion ojQuestion) {
        return toAjax(ojQuestionService.updateOjQuestion(ojQuestion));
    }

    /**
     * 删除题目管理
     */
    @PreAuthorize("@ss.hasPermi('system:question:remove')")
    @Log(title = "题目管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{questionIds}")
    public AjaxResult remove(@PathVariable Long[] questionIds) {
        return toAjax(ojQuestionService.deleteOjQuestionByQuestionIds(questionIds));
    }
}
