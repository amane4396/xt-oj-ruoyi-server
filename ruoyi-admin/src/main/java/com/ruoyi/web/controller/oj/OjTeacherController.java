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
import com.ruoyi.system.domain.OjTeacher;
import com.ruoyi.system.service.IOjTeacherService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * teacherController
 * 
 * @author ruoyi
 * @date 2024-04-18
 */
@RestController
@RequestMapping("/oj/teacher")
public class OjTeacherController extends BaseController
{
    @Autowired
    private IOjTeacherService ojTeacherService;

    /**
     * 查询teacher列表
     */
    @GetMapping("/list")
    public TableDataInfo list(OjTeacher ojTeacher)
    {
        startPage();
        List<OjTeacher> list = ojTeacherService.selectOjTeacherList(ojTeacher);
        return getDataTable(list);
    }

    /**
     * 导出teacher列表
     */
    @Log(title = "teacher", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OjTeacher ojTeacher)
    {
        List<OjTeacher> list = ojTeacherService.selectOjTeacherList(ojTeacher);
        ExcelUtil<OjTeacher> util = new ExcelUtil<OjTeacher>(OjTeacher.class);
        util.exportExcel(response, list, "teacher数据");
    }

    /**
     * 获取teacher详细信息
     */
    @GetMapping(value = "/{teacherId}")
    public AjaxResult getInfo(@PathVariable("teacherId") Long teacherId)
    {
        return success(ojTeacherService.selectOjTeacherByTeacherId(teacherId));
    }

    /**
     * 新增teacher
     */
    @Log(title = "teacher", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OjTeacher ojTeacher)
    {
        return toAjax(ojTeacherService.insertOjTeacher(ojTeacher));
    }

    /**
     * 修改teacher
     */
    @Log(title = "teacher", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjTeacher ojTeacher)
    {
        return toAjax(ojTeacherService.updateOjTeacher(ojTeacher));
    }

    /**
     * 删除teacher
     */
    @Log(title = "teacher", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teacherIds}")
    public AjaxResult remove(@PathVariable Long[] teacherIds)
    {
        return toAjax(ojTeacherService.deleteOjTeacherByTeacherIds(teacherIds));
    }
}
