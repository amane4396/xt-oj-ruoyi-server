package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjClassLessonMapper;
import com.ruoyi.system.domain.OjClassLesson;
import com.ruoyi.system.service.IOjClassLessonService;

/**
 * 课程班级关联Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjClassLessonServiceImpl extends ServiceImpl<OjClassLessonMapper, OjClassLesson> implements IOjClassLessonService {
    @Autowired
    private OjClassLessonMapper ojClassLessonMapper;

    /**
     * 查询课程班级关联
     *
     * @param lessonId 课程班级关联主键
     * @return 课程班级关联
     */
    @Override
    public OjClassLesson selectOjClassLessonByLessonId(Long lessonId) {
        return ojClassLessonMapper.selectOjClassLessonByLessonId(lessonId);
    }

    /**
     * 查询课程班级关联列表
     *
     * @param ojClassLesson 课程班级关联
     * @return 课程班级关联
     */
    @Override
    public List<OjClassLesson> selectOjClassLessonList(OjClassLesson ojClassLesson) {
        return ojClassLessonMapper.selectOjClassLessonList(ojClassLesson);
    }

    /**
     * 新增课程班级关联
     *
     * @param ojClassLesson 课程班级关联
     * @return 结果
     */
    @Override
    public int insertOjClassLesson(OjClassLesson ojClassLesson) {
            return ojClassLessonMapper.insertOjClassLesson(ojClassLesson);
    }

    /**
     * 修改课程班级关联
     *
     * @param ojClassLesson 课程班级关联
     * @return 结果
     */
    @Override
    public int updateOjClassLesson(OjClassLesson ojClassLesson) {
        return ojClassLessonMapper.updateOjClassLesson(ojClassLesson);
    }

    /**
     * 批量删除课程班级关联
     *
     * @param lessonIds 需要删除的课程班级关联主键
     * @return 结果
     */
    @Override
    public int deleteOjClassLessonByLessonIds(Long[] lessonIds) {
        return ojClassLessonMapper.deleteOjClassLessonByLessonIds(lessonIds);
    }

    /**
     * 删除课程班级关联信息
     *
     * @param lessonId 课程班级关联主键
     * @return 结果
     */
    @Override
    public int deleteOjClassLessonByLessonId(Long lessonId) {
        return ojClassLessonMapper.deleteOjClassLessonByLessonId(lessonId);
    }
}
