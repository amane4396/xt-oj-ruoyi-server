package com.ruoyi.system.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.OjClassLesson;

/**
 * 课程班级关联Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjClassLessonMapper extends BaseMapper<OjClassLesson> {
    /**
     * 查询课程班级关联
     *
     * @param lessonId 课程班级关联主键
     * @return 课程班级关联
     */
    public OjClassLesson selectOjClassLessonByLessonId(Long lessonId);

    /**
     * 查询课程班级关联列表
     *
     * @param ojClassLesson 课程班级关联
     * @return 课程班级关联集合
     */
    public List<OjClassLesson> selectOjClassLessonList(OjClassLesson ojClassLesson);

    /**
     * 新增课程班级关联
     *
     * @param ojClassLesson 课程班级关联
     * @return 结果
     */
    public int insertOjClassLesson(OjClassLesson ojClassLesson);

    /**
     * 修改课程班级关联
     *
     * @param ojClassLesson 课程班级关联
     * @return 结果
     */
    public int updateOjClassLesson(OjClassLesson ojClassLesson);

    /**
     * 删除课程班级关联
     *
     * @param lessonId 课程班级关联主键
     * @return 结果
     */
    public int deleteOjClassLessonByLessonId(Long lessonId);

    /**
     * 批量删除课程班级关联
     *
     * @param lessonIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjClassLessonByLessonIds(Long[] lessonIds);
}
