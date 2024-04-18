package com.ruoyi.system.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.OjLesson;

/**
 * 课程管理Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjLessonMapper extends BaseMapper<OjLesson> {
    /**
     * 查询课程管理
     *
     * @param lessonId 课程管理主键
     * @return 课程管理
     */
    public OjLesson selectOjLessonByLessonId(Long lessonId);

    /**
     * 查询课程管理列表
     *
     * @param ojLesson 课程管理
     * @return 课程管理集合
     */
    public List<OjLesson> selectOjLessonList(OjLesson ojLesson);

    /**
     * 新增课程管理
     *
     * @param ojLesson 课程管理
     * @return 结果
     */
    public int insertOjLesson(OjLesson ojLesson);

    /**
     * 修改课程管理
     *
     * @param ojLesson 课程管理
     * @return 结果
     */
    public int updateOjLesson(OjLesson ojLesson);

    /**
     * 删除课程管理
     *
     * @param lessonId 课程管理主键
     * @return 结果
     */
    public int deleteOjLessonByLessonId(Long lessonId);

    /**
     * 批量删除课程管理
     *
     * @param lessonIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjLessonByLessonIds(Long[] lessonIds);
}
