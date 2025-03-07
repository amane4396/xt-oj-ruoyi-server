package com.ruoyi.system.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.ruoyi.common.core.Question;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.CustomClassLoader;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.Task;
import com.ruoyi.system.domain.OjCase;
import com.ruoyi.system.domain.OjStudent;
import com.ruoyi.system.domain.vo.LogReturnVo;
import com.ruoyi.system.mapper.OjCaseMapper;
import com.ruoyi.system.service.IOjCaseService;
import com.ruoyi.system.service.IOjStudentService;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
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

    @Resource
    private IOjStudentService studentService;

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
    public AjaxResult submit(OjSubmitLog log) throws Exception {
        Long userId = SecurityUtils.getUserId();
        log.setCreateTime(DateUtils.getNowDate());
        OjStudent student = studentService.getOne(new LambdaQueryWrapper<OjStudent>().eq(OjStudent::getUserId, userId));
        if (!Objects.isNull(student)) {
            log.setStudentId(student.getStudentId());
        }
        Question question = new Question();
        question.setCode(log.getCode());
        question.setStdin("");
        LogReturnVo logReturnVo = new LogReturnVo();
        LambdaQueryWrapper<OjCase> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(OjCase::getQuestionId, log.getQuestionId());
        List<OjCase> examples = iOjCaseService.list(lambdaQueryWrapper);
        // 编译代码
        CustomClassLoader customClassLoader = new CustomClassLoader();
        int count = examples.size();
        Task task = new Task();
        try {
            task.compile(question);
        } catch (Exception e) {
            log.setRemark(e.getMessage());
            logReturnVo.setRemark("编译失败;" + e.getMessage());
            logReturnVo.setRunTime("");
            logReturnVo.setRunCondition("0/" + count);
            log.setStatus("0");
            log.setPassNum(0L);
            ojSubmitLogMapper.insert(log);
            return AjaxResult.success(logReturnVo);
        }
        // 加载类获取方法反射
        Class<?> cls = customClassLoader.loadClassFromFile("./tmp/Solution.class");
        Method solution = null;
        try{
            solution = cls.getMethod("solution", String.class);
        }catch (Exception e){
            log.setRemark(e.getMessage());
            logReturnVo.setRemark("缺少方法solution");
            logReturnVo.setRunTime("");
            logReturnVo.setRunCondition("0/" + count);
            log.setStatus("0");
            log.setPassNum(0L);
            ojSubmitLogMapper.insert(log);
            return AjaxResult.error(logReturnVo.getRemark());
        }


        int passed = 0;
        long begin = System.nanoTime();
        solution.setAccessible(true);
        for (OjCase example : examples) {
            String str = solution.invoke(cls, example.getInput()).toString();
            if (str.equals(example.getResult())) {
                passed++;
            } else {
                log.setRemark(example.getInput());
            }
        }
        long end = System.nanoTime();

        if (passed == count) {
            log.setStatus("1");
            log.setRemark("通过");
            log.setRemark("ACCEPT");
            log.setPassNum((long) passed);
            log.setRunTime((end - begin) + "ms");
            logReturnVo.setRunCondition(count + "/" + count);
            logReturnVo.setRemark("通过");
            logReturnVo.setRunTime(passed + "ms");
        } else {
            log.setStatus("2");
            log.setPassNum((long) passed);
            log.setRunTime((end - begin) + "ms");
            log.setRemark("样例未全部通过");
            logReturnVo.setRunCondition(passed + "/" + count + "ms");
            logReturnVo.setRemark("样例未全部通过");
            logReturnVo.setRunTime(String.valueOf(passed));
        }

        log.setRunTime(String.valueOf(end - begin));
        iOjSubmitLogService.save(log);
        return AjaxResult.success(logReturnVo);
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
