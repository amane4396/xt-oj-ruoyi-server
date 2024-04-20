package com.ruoyi.web.controller.oj;

import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import ch.qos.logback.core.util.StringCollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.OjStudent;
import com.ruoyi.system.domain.dto.RunCodeDto;
import com.ruoyi.system.service.IOjQuestionService;
import com.ruoyi.system.service.IOjStudentService;
import io.swagger.annotations.ApiOperation;
import org.aspectj.weaver.loadtime.Aj;
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
import com.ruoyi.system.domain.OjSubmitLog;
import com.ruoyi.system.service.IOjSubmitLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提交样例记录Controller
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@RestController
@RequestMapping("/system/submitLog")
public class OjSubmitLogController extends BaseController {
    @Autowired
    private IOjSubmitLogService ojSubmitLogService;

    @Resource
    private IOjQuestionService questionService;

    @Resource
    private IOjStudentService studentService;

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private IOjSubmitLogService iOjSubmitLogService;


    @PostMapping("/runCode")
    @ApiOperation("测试代码")
    public AjaxResult runCode(@RequestBody String requestBody) throws Exception {
        RunCodeDto dto = objectMapper.readValue(requestBody, RunCodeDto.class);
        return iOjSubmitLogService.runCode(dto.getCode());
    }

    /**
     * 提交代码
     *
     * @param requestBody RequestBody
     * @return AjaxResult AjaxResult
     * @throws Exception Exception
     */
    @PostMapping("/submit")
    @ApiOperation("测试提交")
    public AjaxResult test(@RequestBody OjSubmitLog log) throws Exception {
//        OjSubmitLog log = objectMapper.readValue(requestBody, OjSubmitLog.class);
        return iOjSubmitLogService.submit(log);
    }

    @GetMapping("/listByQuestionId/{questionId}")
    public AjaxResult listByQuestionId(@PathVariable Long questionId) {
        OjStudent student = studentService.getOne(new LambdaQueryWrapper<OjStudent>().eq(OjStudent::getUserId, SecurityUtils.getUserId()));
        Long studentId = null;
        if (!Objects.isNull(student)) {
            studentId = student.getStudentId();
        }
        List<OjSubmitLog> list = ojSubmitLogService.list(new LambdaQueryWrapper<OjSubmitLog>().eq(OjSubmitLog::getQuestionId, questionId).eq(OjSubmitLog::getStudentId, studentId));
        return AjaxResult.success(list);
    }

    /**
     * 查询提交样例记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:submitLog:list')")
    @GetMapping("/list")
    public TableDataInfo list(OjSubmitLog ojSubmitLog) {
        startPage();
        List<OjSubmitLog> list = ojSubmitLogService.selectOjSubmitLogList(ojSubmitLog);
        return getDataTable(list);
    }

    /**
     * 导出提交样例记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:submitLog:export')")
    @Log(title = "提交样例记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OjSubmitLog ojSubmitLog) {
        List<OjSubmitLog> list = ojSubmitLogService.selectOjSubmitLogList(ojSubmitLog);
        ExcelUtil<OjSubmitLog> util = new ExcelUtil<OjSubmitLog>(OjSubmitLog.class);
        util.exportExcel(response, list, "提交样例记录数据");
    }

    /**
     * 获取提交样例记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:submitLog:query')")
    @GetMapping(value = "/{submitLogId}")
    public AjaxResult getInfo(@PathVariable("submitLogId") Long submitLogId) {
        return success(ojSubmitLogService.selectOjSubmitLogBySubmitLogId(submitLogId));
    }

    /**
     * 新增提交样例记录
     */
    @PreAuthorize("@ss.hasPermi('system:submitLog:add')")
    @Log(title = "提交样例记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OjSubmitLog ojSubmitLog) {
        return toAjax(ojSubmitLogService.insertOjSubmitLog(ojSubmitLog));
    }

    /**
     * 修改提交样例记录
     */
    @PreAuthorize("@ss.hasPermi('system:submitLog:edit')")
    @Log(title = "提交样例记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjSubmitLog ojSubmitLog) {
        return toAjax(ojSubmitLogService.updateOjSubmitLog(ojSubmitLog));
    }

    /**
     * 删除提交样例记录
     */
    @PreAuthorize("@ss.hasPermi('system:submitLog:remove')")
    @Log(title = "提交样例记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{submitLogIds}")
    public AjaxResult remove(@PathVariable Long[] submitLogIds) {
        return toAjax(ojSubmitLogService.deleteOjSubmitLogBySubmitLogIds(submitLogIds));
    }
}
