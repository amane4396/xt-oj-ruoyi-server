package com.ruoyi.web.controller.oj;

import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.OjSubmitLog;
import com.ruoyi.system.service.IOjSubmitLogService;
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
import com.ruoyi.system.domain.OjScore;
import com.ruoyi.system.service.IOjScoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 题目批改得分Controller
 *
 * @author ruoyi
 * @date 2024-04-21
 */
@RestController
@RequestMapping("/system/score")
public class OjScoreController extends BaseController {
    @Autowired
    private IOjScoreService ojScoreService;

    @Resource
    private IOjSubmitLogService submitLogService;

    /**
     * 查询题目批改得分列表
     */
    @GetMapping("/list")
    public TableDataInfo list(OjScore ojScore) {
        startPage();
        List<OjScore> list = ojScoreService.selectOjScoreList(ojScore);
        return getDataTable(list);
    }

    /**
     * 导出题目批改得分列表
     */
    @Log(title = "题目批改得分", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OjScore ojScore) {
        List<OjScore> list = ojScoreService.selectOjScoreList(ojScore);
        ExcelUtil<OjScore> util = new ExcelUtil<OjScore>(OjScore.class);
        util.exportExcel(response, list, "题目批改得分数据");
    }

    /**
     * 获取题目批改得分详细信息
     */
    @GetMapping(value = "/{scoreId}")
    public AjaxResult getInfo(@PathVariable("scoreId") Long scoreId) {
        return success(ojScoreService.selectOjScoreByScoreId(scoreId));
    }

    /**
     * 新增题目批改得分
     */
    @Log(title = "题目批改得分", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OjScore ojScore) {
        if (!Objects.isNull(ojScore.getSubmitLogId())) {
            OjSubmitLog submitLog = new OjSubmitLog();
            submitLog.setSubmitLogId(ojScore.getSubmitLogId());
            submitLog.setCorrected(1);
            submitLogService.updateOjSubmitLog(submitLog);
        }
        return toAjax(ojScoreService.insertOjScore(ojScore));
    }

    /**
     * 修改题目批改得分
     */
    @Log(title = "题目批改得分", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OjScore ojScore) {
        return toAjax(ojScoreService.updateOjScore(ojScore));
    }

    /**
     * 删除题目批改得分
     */
    @Log(title = "题目批改得分", businessType = BusinessType.DELETE)
    @DeleteMapping("/{scoreIds}")
    public AjaxResult remove(@PathVariable Long[] scoreIds) {
        return toAjax(ojScoreService.deleteOjScoreByScoreIds(scoreIds));
    }
}
