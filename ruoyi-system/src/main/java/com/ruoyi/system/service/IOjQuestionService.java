package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OjQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 题目管理Service接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface IOjQuestionService extends IService<OjQuestion> {
    /**
     * 查询题目管理
     *
     * @param questionId 题目管理主键
     * @return 题目管理
     */
    public OjQuestion selectOjQuestionByQuestionId(Long questionId);

    /**
     * 查询题目管理列表
     *
     * @param ojQuestion 题目管理
     * @return 题目管理集合
     */
    public List<OjQuestion> selectOjQuestionList(OjQuestion ojQuestion);

    /**
     * 新增题目管理
     *
     * @param ojQuestion 题目管理
     * @return 结果
     */
    public int insertOjQuestion(OjQuestion ojQuestion);

    /**
     * 修改题目管理
     *
     * @param ojQuestion 题目管理
     * @return 结果
     */
    public int updateOjQuestion(OjQuestion ojQuestion);

    /**
     * 批量删除题目管理
     *
     * @param questionIds 需要删除的题目管理主键集合
     * @return 结果
     */
    public int deleteOjQuestionByQuestionIds(Long[] questionIds);

    /**
     * 删除题目管理信息
     *
     * @param questionId 题目管理主键
     * @return 结果
     */
    public int deleteOjQuestionByQuestionId(Long questionId);

    List<OjQuestion> selectOjQuestionListByLessonId(Long lessonId);
}
