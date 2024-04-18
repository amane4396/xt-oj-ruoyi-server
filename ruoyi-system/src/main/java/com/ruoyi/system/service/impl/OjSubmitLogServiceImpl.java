package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjSubmitLogMapper;
import com.ruoyi.system.domain.OjSubmitLog;
import com.ruoyi.system.service.IOjSubmitLogService;

/**
 * 提交样例记录Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjSubmitLogServiceImpl extends ServiceImpl<OjSubmitLogMapper, OjSubmitLog> implements IOjSubmitLogService {
    @Autowired
    private OjSubmitLogMapper ojSubmitLogMapper;

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
}
