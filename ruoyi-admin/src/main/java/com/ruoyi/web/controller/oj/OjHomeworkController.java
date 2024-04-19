package com.ruoyi.web.controller.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.system.domain.OjQuestion;
import com.ruoyi.system.domain.OjTeacher;
import com.ruoyi.system.domain.vo.AddHomeworkDto;
import com.ruoyi.system.domain.vo.HomeWorkVo;
import com.ruoyi.system.service.IOjQuestionService;
import com.ruoyi.system.service.IOjTeacherService;
import org.apache.poi.xddf.usermodel.text.TabAlignment;
import org.springframework.beans.BeanUtils;
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
import com.ruoyi.system.domain.OjHomework;
import com.ruoyi.system.service.IOjHomeworkService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 作业管理Controller
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@RestController
@RequestMapping("/system/homework")
public class OjHomeworkController extends BaseController {
    @Autowired
    private IOjHomeworkService ojHomeworkService;

    @Autowired
    private IOjTeacherService ojTeacherService;

    @Autowired
    private IOjQuestionService ojQuestionService;

//    @PostMapping("/add")
//    public AjaxResult addHomework(@RequestBody AddHomeworkDto dto){
//        ojHomeworkService.addHomework(dto);
//        return AjaxResult.success("作业添加成功");
//    }

    /**
     * 查询作业管理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(OjHomework ojHomework) {
        startPage();
        List<OjHomework> list = ojHomeworkService.selectOjHomeworkList(ojHomework);
        return getDataTable(list);
    }

    @GetMapping("/listByLessonId/{lessonId}")
    public AjaxResult listByLessonId(@PathVariable Long lessonId) {
        List<OjHomework> list = ojHomeworkService.list(new LambdaQueryWrapper<OjHomework>().eq(OjHomework::getLessonId, lessonId));
        for (OjHomework ojHomework : list) {
            if (!ojHomework.getQuestionIds().isEmpty()) {
                String[] questionList = ojHomework.getQuestionIds().split(",");
                List<OjQuestion> ojQuestions = ojQuestionService.listByIds(Arrays.asList(questionList));
                ojHomework.setQuestionList(ojQuestions);
            }
        }
        return AjaxResult.success(list);
    }


    /**
     * 导出作业管理列表
     */
    @Log(title = "作业管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OjHomework ojHomework) {
        List<OjHomework> list = ojHomeworkService.selectOjHomeworkList(ojHomework);
        ExcelUtil<OjHomework> util = new ExcelUtil<OjHomework>(OjHomework.class);
        util.exportExcel(response, list, "作业管理数据");
    }

    /**
     * 获取作业管理详细信息
     */
    @GetMapping(value = "/{homeworkId}")
    public AjaxResult getInfo(@PathVariable("homeworkId") Long homeworkId) {
        return success(ojHomeworkService.selectOjHomeworkByHomeworkId(homeworkId));
    }

    /**
     * 新增作业管理
     */
    @Log(title = "作业管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OjHomework ojHomework) {
        return toAjax(ojHomeworkService.insertOjHomework(ojHomework));
    }

    /**
     * 修改作业管理
     */
    @Log(title = "作业管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjHomework ojHomework) {
        return toAjax(ojHomeworkService.updateOjHomework(ojHomework));
    }

    /**
     * 删除作业管理
     */
    @Log(title = "作业管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{homeworkIds}")
    public AjaxResult remove(@PathVariable Long[] homeworkIds) {
        return toAjax(ojHomeworkService.deleteOjHomeworkByHomeworkIds(homeworkIds));
    }
}
