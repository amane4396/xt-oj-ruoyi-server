package com.ruoyi.system.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.OjSubmitLog;

/**
 * 提交样例记录Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjSubmitLogMapper extends BaseMapper<OjSubmitLog> {
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
     * 删除提交样例记录
     *
     * @param submitLogId 提交样例记录主键
     * @return 结果
     */
    public int deleteOjSubmitLogBySubmitLogId(Long submitLogId);

    /**
     * 批量删除提交样例记录
     *
     * @param submitLogIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjSubmitLogBySubmitLogIds(Long[] submitLogIds);
}
