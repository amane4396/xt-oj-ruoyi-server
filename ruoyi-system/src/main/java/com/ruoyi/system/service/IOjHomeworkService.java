package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OjHomework;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 作业管理Service接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface IOjHomeworkService extends IService<OjHomework> {
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
     * 批量删除作业管理
     *
     * @param homeworkIds 需要删除的作业管理主键集合
     * @return 结果
     */
    public int deleteOjHomeworkByHomeworkIds(Long[] homeworkIds);

    /**
     * 删除作业管理信息
     *
     * @param homeworkId 作业管理主键
     * @return 结果
     */
    public int deleteOjHomeworkByHomeworkId(Long homeworkId);
}
