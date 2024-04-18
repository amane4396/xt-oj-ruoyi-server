package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjLessonMapper;
import com.ruoyi.system.domain.OjLesson;
import com.ruoyi.system.service.IOjLessonService;

/**
 * 课程管理Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjLessonServiceImpl extends ServiceImpl<OjLessonMapper, OjLesson> implements IOjLessonService {
    @Autowired
    private OjLessonMapper ojLessonMapper;

    /**
     * 查询课程管理
     *
     * @param lessonId 课程管理主键
     * @return 课程管理
     */
    @Override
    public OjLesson selectOjLessonByLessonId(Long lessonId) {
        return ojLessonMapper.selectOjLessonByLessonId(lessonId);
    }

    /**
     * 查询课程管理列表
     *
     * @param ojLesson 课程管理
     * @return 课程管理
     */
    @Override
    public List<OjLesson> selectOjLessonList(OjLesson ojLesson) {
        return ojLessonMapper.selectOjLessonList(ojLesson);
    }

    /**
     * 新增课程管理
     *
     * @param ojLesson 课程管理
     * @return 结果
     */
    @Override
    public int insertOjLesson(OjLesson ojLesson) {
        ojLesson.setCreateTime(DateUtils.getNowDate());
        return ojLessonMapper.insertOjLesson(ojLesson);
    }

    /**
     * 修改课程管理
     *
     * @param ojLesson 课程管理
     * @return 结果
     */
    @Override
    public int updateOjLesson(OjLesson ojLesson) {
        ojLesson.setUpdateTime(DateUtils.getNowDate());
        return ojLessonMapper.updateOjLesson(ojLesson);
    }

    /**
     * 批量删除课程管理
     *
     * @param lessonIds 需要删除的课程管理主键
     * @return 结果
     */
    @Override
    public int deleteOjLessonByLessonIds(Long[] lessonIds) {
        return ojLessonMapper.deleteOjLessonByLessonIds(lessonIds);
    }

    /**
     * 删除课程管理信息
     *
     * @param lessonId 课程管理主键
     * @return 结果
     */
    @Override
    public int deleteOjLessonByLessonId(Long lessonId) {
        return ojLessonMapper.deleteOjLessonByLessonId(lessonId);
    }
}
