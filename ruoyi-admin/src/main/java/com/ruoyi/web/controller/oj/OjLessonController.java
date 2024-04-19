package com.ruoyi.web.controller.oj;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程管理Controller
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@RestController
@RequestMapping("/system/lesson")
public class OjLessonController extends BaseController {
    @Autowired
    private IOjLessonService ojLessonService;


    @Autowired
    private IOjClassLessonService classLessonService;

    @Autowired
    private IOjClassTeacherService classTeacherService;


    @Autowired
    private IOjTeacherService teacherService;

    @Autowired
    private IOjStudentService studentService;

    @Autowired
    private IOjClassStudentService classStudentService;


    /**
     * 查询课程管理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(OjLesson ojLesson) {
        startPage();
        List<OjLesson> list = ojLessonService.selectOjLessonList(ojLesson);
        return getDataTable(list);
    }

    @GetMapping("/listAllLesson")
    public List<OjLesson> listAllLesson(OjLesson ojLesson) {
        return ojLessonService.selectOjLessonList(ojLesson);
    }

    @GetMapping("/getLessonByTeacherId")
    public List<OjLesson> getLessonByTeacherId() {
        Long userId = SecurityUtils.getUserId();
        OjTeacher teacher = teacherService.getOne(new LambdaQueryWrapper<OjTeacher>().eq(OjTeacher::getUserId, userId));
        List<OjClassTeacher> ojClassTeacherList = classTeacherService.list(new LambdaQueryWrapper<OjClassTeacher>().eq(OjClassTeacher::getOjTeacherId, teacher.getTeacherId()));
        List<Long> lessonIds = new ArrayList<>();
        for (OjClassTeacher ojClassTeacher : ojClassTeacherList) {
            classLessonService.list(new LambdaQueryWrapper<OjClassLesson>().eq(OjClassLesson::getClassId, ojClassTeacher.getOjClassId())).forEach(
                    ojClassLesson -> lessonIds.add(ojClassLesson.getLessonId())
            );
        }
        return CollectionUtil.distinct(ojLessonService.listByIds(lessonIds));
    }

    @GetMapping("/getLessonByStudentId")
    public List<OjLesson> getLessonByStudentId() {
        Long userId = SecurityUtils.getUserId();
        OjStudent student = studentService.getOne(new LambdaQueryWrapper<OjStudent>().eq(OjStudent::getUserId, userId));
        List<OjClassStudent> ojClassStudentList = classStudentService.list(new LambdaQueryWrapper<OjClassStudent>().eq(OjClassStudent::getOjStudentId, student.getStudentId()));
        List<Long> lessonIds = new ArrayList<>();
        for (OjClassStudent ojClassStudent : ojClassStudentList) {
            classLessonService.list(new LambdaQueryWrapper<OjClassLesson>().eq(OjClassLesson::getClassId, ojClassStudent.getOjClassId())).forEach(
                    ojClassLesson -> lessonIds.add(ojClassLesson.getLessonId())
            );
        }
        return CollectionUtil.distinct(ojLessonService.listByIds(lessonIds));
    }

    /**
     * 导出课程管理列表
     */
    @Log(title = "课程管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OjLesson ojLesson) {
        List<OjLesson> list = ojLessonService.selectOjLessonList(ojLesson);
        ExcelUtil<OjLesson> util = new ExcelUtil<OjLesson>(OjLesson.class);
        util.exportExcel(response, list, "课程管理数据");
    }

    /**
     * 获取课程管理详细信息
     */
    @GetMapping(value = "/{lessonId}")
    public AjaxResult getInfo(@PathVariable("lessonId") Long lessonId) {
        return success(ojLessonService.selectOjLessonByLessonId(lessonId));
    }

    /**
     * 新增课程管理
     */
    @Log(title = "课程管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody String requestBody) {
        JSONObject entries = JSONUtil.parseObj(requestBody);
        String name = entries.getStr("name");
        String description = entries.getStr("description");
        List<Integer> classIds = entries.getBeanList("classIds", Integer.class);
        OjLesson ojLesson = new OjLesson();
        ojLesson.setName(name);
        ojLesson.setDescription(description);
        int lessonId = ojLessonService.insertOjLesson(ojLesson);
        for (Integer classId : classIds) {
            OjClassLesson ojClassLesson = new OjClassLesson();
            ojClassLesson.setLessonId((long) lessonId);
            ojClassLesson.setClassId((long) classId);
            classLessonService.insertOjClassLesson(ojClassLesson);
        }
        return success("添加成功");
    }

    /**
     * 修改课程管理
     */
    @Log(title = "课程管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjLesson ojLesson) {
        return toAjax(ojLessonService.updateOjLesson(ojLesson));
    }

    /**
     * 删除课程管理
     */
    @Log(title = "课程管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{lessonIds}")
    public AjaxResult remove(@PathVariable Long[] lessonIds) {
        return toAjax(ojLessonService.deleteOjLessonByLessonIds(lessonIds));
    }
}
