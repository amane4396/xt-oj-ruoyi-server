package com.ruoyi.web.controller.oj;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.system.domain.OjHomework;
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

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 根据作业id查题目
     */
    @GetMapping("/getList")
    public TableDataInfo listByHomeWorkId(@RequestBody OjHomework homework){
        String values = homework.getQuestionIds();
        String[] ids = values.split(",");
        List<OjQuestion> list = new ArrayList<>();
        for(String str : ids){
            OjQuestion question =  ojQuestionService.getById(Long.valueOf(str));
            list.add(question);
        }
        return getDataTable(list);
    }

    /**
     * 查询题目管理列表
     */
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
    @GetMapping(value = "/{questionId}")
    public AjaxResult getInfo(@PathVariable("questionId") Long questionId) {
        return success(ojQuestionService.selectOjQuestionByQuestionId(questionId));
    }

    /**
     * 新增题目管理
     */
    @Log(title = "题目管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OjQuestion ojQuestion) {
        return toAjax(ojQuestionService.insertOjQuestion(ojQuestion));
    }

    // 根据课程id查询所有的题目
    @GetMapping("/selectOjQuestionListByLessonId/{lessonId}")
    public List<OjQuestion> listAllQuestionByCourseId(@PathVariable Long lessonId) {
        return ojQuestionService.selectOjQuestionListByLessonId(lessonId);
    }

    /**
     * 修改题目管理
     */
    @Log(title = "题目管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjQuestion ojQuestion) {
        return toAjax(ojQuestionService.updateOjQuestion(ojQuestion));
    }

    /**
     * 删除题目管理
     */
    @Log(title = "题目管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{questionIds}")
    public AjaxResult remove(@PathVariable Long[] questionIds) {
        return toAjax(ojQuestionService.deleteOjQuestionByQuestionIds(questionIds));
    }
}
