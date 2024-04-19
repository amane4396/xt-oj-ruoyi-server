package com.ruoyi.web.controller.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.OjClass;
import com.ruoyi.system.domain.OjClassLesson;
import com.ruoyi.system.domain.OjClassStudent;
import com.ruoyi.system.service.*;
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
import com.ruoyi.system.domain.OjStudent;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生管理Controller
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@RestController
@RequestMapping("/oj/student")
public class OjStudentController extends BaseController
{
    @Autowired
    private IOjStudentService ojStudentService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysUserService sysUserService;

    @Resource
    private IOjClassLessonService iOjClassLessonService;

    @Resource
    private IOjClassStudentService iOjClassStudentService;

    @Resource
    private IOjClassService iOjClassService;

    @Resource
    private IOjStudentService iOjStudentService;

    @GetMapping("/listByLessonId/{lessonId}")
    public List<Map<String, List<OjStudent>>> listByLessonId(@PathVariable("lessonId") Long lessonId){
        List<Map<String, List<OjStudent>>> res = new ArrayList<>();
        iOjClassLessonService.list(new LambdaQueryWrapper<OjClassLesson>().eq(OjClassLesson::getLessonId, lessonId)).forEach( a -> {
            List<OjStudent> students = new ArrayList<>();
            OjClass ojClass = iOjClassService.getById(a.getClassId());
            Map<String, List<OjStudent>> value = new HashMap<>();
            iOjClassStudentService.list(new LambdaQueryWrapper<OjClassStudent>().eq(OjClassStudent::getOjClassId, a.getClassId())).forEach(ojClassStudent -> {
                OjStudent student = iOjStudentService.getById(ojClassStudent.getOjStudentId());
                Long userId = student.getUserId();
                SysUser sysUser = sysUserService.selectUserById(userId);
                student.setSysUser(sysUser);
                students.add(student);
            });
            if (students.size() != 0){
                value.put(ojClass.getClassName(), students);
                res.add(value);
            }
        });
        return res;
    }

    /**
     * 查询学生管理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(OjStudent ojStudent)
    {
        startPage();
        List<OjStudent> list = ojStudentService.selectOjStudentList(ojStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生管理列表
     */
    @Log(title = "学生管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OjStudent ojStudent)
    {
        List<OjStudent> list = ojStudentService.selectOjStudentList(ojStudent);
        ExcelUtil<OjStudent> util = new ExcelUtil<OjStudent>(OjStudent.class);
        util.exportExcel(response, list, "学生管理数据");
    }

    /**
     * 获取学生管理详细信息
     */
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(ojStudentService.selectOjStudentByStudentId(studentId));
    }

    /**
     * 新增学生管理
     */
    @Log(title = "学生管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OjStudent ojStudent)
    {
        return toAjax(ojStudentService.insertOjStudent(ojStudent));
    }

    /**
     * 修改学生管理
     */
    @Log(title = "学生管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjStudent ojStudent)
    {
        return toAjax(ojStudentService.updateOjStudent(ojStudent));
    }

    /**
     * 删除学生管理
     */
    @Log(title = "学生管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(ojStudentService.deleteOjStudentByStudentIds(studentIds));
    }
}
