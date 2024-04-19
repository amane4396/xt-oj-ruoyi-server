package com.ruoyi.web.controller.oj;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.system.domain.OjClass;
import com.ruoyi.system.domain.OjClassLesson;
import com.ruoyi.system.service.IOjClassLessonService;
import io.swagger.models.auth.In;
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
import com.ruoyi.system.domain.OjLesson;
import com.ruoyi.system.service.IOjLessonService;
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


    /**
     * 查询课程管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:list')")
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

    /**
     * 导出课程管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:export')")
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
    @PreAuthorize("@ss.hasPermi('system:lesson:query')")
    @GetMapping(value = "/{lessonId}")
    public AjaxResult getInfo(@PathVariable("lessonId") Long lessonId) {
        return success(ojLessonService.selectOjLessonByLessonId(lessonId));
    }

    /**
     * 新增课程管理
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:add')")
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
    @PreAuthorize("@ss.hasPermi('system:lesson:edit')")
    @Log(title = "课程管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjLesson ojLesson) {
        return toAjax(ojLessonService.updateOjLesson(ojLesson));
    }

    /**
     * 删除课程管理
     */
    @PreAuthorize("@ss.hasPermi('system:lesson:remove')")
    @Log(title = "课程管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{lessonIds}")
    public AjaxResult remove(@PathVariable Long[] lessonIds) {
        return toAjax(ojLessonService.deleteOjLessonByLessonIds(lessonIds));
    }
}
