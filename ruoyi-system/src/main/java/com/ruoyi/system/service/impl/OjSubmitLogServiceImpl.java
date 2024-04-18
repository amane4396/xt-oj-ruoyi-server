package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.lang.reflect.Method;
import java.util.List;

import com.ruoyi.common.core.Question;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.CustomClassLoader;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.Task;
import com.ruoyi.system.domain.OjCase;
import com.ruoyi.system.mapper.OjCaseMapper;
import com.ruoyi.system.service.IOjCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjSubmitLogMapper;
import com.ruoyi.system.domain.OjSubmitLog;
import com.ruoyi.system.service.IOjSubmitLogService;

import javax.annotation.Resource;

/**
 * 提交样例记录Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjSubmitLogServiceImpl extends ServiceImpl<OjSubmitLogMapper, OjSubmitLog> implements IOjSubmitLogService {
    @Resource
    private OjSubmitLogMapper ojSubmitLogMapper;

    @Resource
    private IOjSubmitLogService iOjSubmitLogService;

    @Resource
    private IOjCaseService iOjCaseService;

    /**
     * 查询提交样例记录
     *
     * @param submitLogId 提交样例记录主键
     * @return 提交样例记录
     */
    @Override
    public OjSubmitLog selectOjSubmitLogBySubmitLogId(Long submitLogId) {
        return ojSubmitLogMapper.selectOjSubmitLogBySubmitLogId(submitLogId);
    }

    /**
     * 查询提交样例记录列表
     *
     * @param ojSubmitLog 提交样例记录
     * @return 提交样例记录
     */
    @Override
    public List<OjSubmitLog> selectOjSubmitLogList(OjSubmitLog ojSubmitLog) {
        return ojSubmitLogMapper.selectOjSubmitLogList(ojSubmitLog);
    }

    /**
     * 新增提交样例记录
     *
     * @param ojSubmitLog 提交样例记录
     * @return 结果
     */
    @Override
    public int insertOjSubmitLog(OjSubmitLog ojSubmitLog) {
        ojSubmitLog.setCreateTime(DateUtils.getNowDate());
        return ojSubmitLogMapper.insertOjSubmitLog(ojSubmitLog);
    }

    /**
     * 修改提交样例记录
     *
     * @param ojSubmitLog 提交样例记录
     * @return 结果
     */
    @Override
    public int updateOjSubmitLog(OjSubmitLog ojSubmitLog) {
        ojSubmitLog.setUpdateTime(DateUtils.getNowDate());
        return ojSubmitLogMapper.updateOjSubmitLog(ojSubmitLog);
    }

    /**
     * 批量删除提交样例记录
     *
     * @param submitLogIds 需要删除的提交样例记录主键
     * @return 结果
     */
    @Override
    public int deleteOjSubmitLogBySubmitLogIds(Long[] submitLogIds) {
        return ojSubmitLogMapper.deleteOjSubmitLogBySubmitLogIds(submitLogIds);
    }

    /**
     * 删除提交样例记录信息
     *
     * @param submitLogId 提交样例记录主键
     * @return 结果
     */
    @Override
    public int deleteOjSubmitLogBySubmitLogId(Long submitLogId) {
        return ojSubmitLogMapper.deleteOjSubmitLogBySubmitLogId(submitLogId);
    }

    @Override
    public AjaxResult submit(OjSubmitLog log) throws Exception{

        Question question = new Question();
        question.setCode(log.getCode());
        question.setStdin("");
        // 编译代码
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Task task = new Task();
        try {
            task.compile(question);
        } catch (Exception e) {
            log.setRemark(e.getMessage());
            log.setStatus("2");
            log.setPassNum(0L);
            ojSubmitLogMapper.insert(log);
            return AjaxResult.error("编译失败:\n" + log.getRemark());
        }
        // 加载类获取方法反射
        Class<?> cls = customClassLoader.loadClassFromFile("./tmp/Solution.class");
        LambdaQueryWrapper<OjCase> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OjCase::getQuestionId, log.getQuestionId());
        Method solution = cls.getMethod("solution", String.class);
        List<OjCase> examples = iOjCaseService.list(lambdaQueryWrapper);
        int count = examples.size();
        int passed = 0;
        long begin = System.currentTimeMillis();
        for(OjCase example : examples){
            String str =  solution.invoke(cls, example.getInput()).toString();
            if(str.equals(example.getResult())){
                passed++;
            }else{
                log.setRemark(example.getInput());
            }
        }
        long end = System.currentTimeMillis();
        if(passed == count){
            log.setStatus("1");
            log.setRemark("通过");
            log.setRemark("ACCEPT");
            log.setPassNum((long)passed);
            log.setRunTime((end - begin) + "ms");
            log.setStudentId(SecurityUtils.getUserId());

        }else{
            log.setCode("2");
            log.setRemark("FAILED");
            log.setPassNum((long)passed);
            log.setRunTime((end - begin) + "ms");
            log.setStudentId(SecurityUtils.getUserId());
            log.setRemark("样例未全部通过");
        }

        log.setRunTime(String.valueOf(end - begin));
        iOjSubmitLogService.insertOjSubmitLog(log);
        return AjaxResult.success(log);
    }

    @Override
    public AjaxResult runCode(String code) {
        Question question = new Question();
        question.setCode(code);
        question.setStdin("");
        // 编译代码
        Task task = new Task();
        try {
            task.compile(question);
        } catch (Exception e) {
            return AjaxResult.error("编译出错：\n" + e.getMessage());
        }
        String res;
        try {
            res = task.run();
        } catch (Exception e) {
            return AjaxResult.success("运行失败:\n" + e.getMessage());
        }
        return AjaxResult.success(res);
    }
}
