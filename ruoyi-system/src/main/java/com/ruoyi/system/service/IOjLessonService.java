package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OjLesson;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 课程管理Service接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface IOjLessonService extends IService<OjLesson> {
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
     * 批量删除课程管理
     *
     * @param lessonIds 需要删除的课程管理主键集合
     * @return 结果
     */
    public int deleteOjLessonByLessonIds(Long[] lessonIds);

    /**
     * 删除课程管理信息
     *
     * @param lessonId 课程管理主键
     * @return 结果
     */
    public int deleteOjLessonByLessonId(Long lessonId);
}
