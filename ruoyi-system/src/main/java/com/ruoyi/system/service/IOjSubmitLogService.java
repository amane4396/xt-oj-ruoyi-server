package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OjSubmitLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 提交样例记录Service接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface IOjSubmitLogService extends IService<OjSubmitLog> {
    /**
     * 查询提交样例记录
     *
     * @param submitLogId 提交样例记录主键
     * @return 提交样例记录
     */
    public OjSubmitLog selectOjSubmitLogBySubmitLogId(Long submitLogId);

    /**
     * 查询提交样例记录列表
     *
     * @param ojSubmitLog 提交样例记录
     * @return 提交样例记录集合
     */
    public List<OjSubmitLog> selectOjSubmitLogList(OjSubmitLog ojSubmitLog);

    /**
     * 新增提交样例记录
     *
     * @param ojSubmitLog 提交样例记录
     * @return 结果
     */
    public int insertOjSubmitLog(OjSubmitLog ojSubmitLog);

    /**
     * 修改提交样例记录
     *
     * @param ojSubmitLog 提交样例记录
     * @return 结果
     */
    public int updateOjSubmitLog(OjSubmitLog ojSubmitLog);

    /**
     * 批量删除提交样例记录
     *
     * @param submitLogIds 需要删除的提交样例记录主键集合
     * @return 结果
     */
    public int deleteOjSubmitLogBySubmitLogIds(Long[] submitLogIds);

    /**
     * 删除提交样例记录信息
     *
     * @param submitLogId 提交样例记录主键
     * @return 结果
     */
    public int deleteOjSubmitLogBySubmitLogId(Long submitLogId);
}
