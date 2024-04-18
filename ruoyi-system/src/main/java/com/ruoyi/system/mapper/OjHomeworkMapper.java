package com.ruoyi.system.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.OjHomework;

/**
 * 作业管理Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjHomeworkMapper extends BaseMapper<OjHomework> {
    /**
     * 查询作业管理
     *
     * @param homeworkId 作业管理主键
     * @return 作业管理
     */
    public OjHomework selectOjHomeworkByHomeworkId(Long homeworkId);

    /**
     * 查询作业管理列表
     *
     * @param ojHomework 作业管理
     * @return 作业管理集合
     */
    public List<OjHomework> selectOjHomeworkList(OjHomework ojHomework);

    /**
     * 新增作业管理
     *
     * @param ojHomework 作业管理
     * @return 结果
     */
    public int insertOjHomework(OjHomework ojHomework);

    /**
     * 修改作业管理
     *
     * @param ojHomework 作业管理
     * @return 结果
     */
    public int updateOjHomework(OjHomework ojHomework);

    /**
     * 删除作业管理
     *
     * @param homeworkId 作业管理主键
     * @return 结果
     */
    public int deleteOjHomeworkByHomeworkId(Long homeworkId);

    /**
     * 批量删除作业管理
     *
     * @param homeworkIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjHomeworkByHomeworkIds(Long[] homeworkIds);
}
