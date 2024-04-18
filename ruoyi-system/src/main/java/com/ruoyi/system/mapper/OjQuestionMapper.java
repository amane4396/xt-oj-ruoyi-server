package com.ruoyi.system.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.OjQuestion;

/**
 * 题目管理Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjQuestionMapper extends BaseMapper<OjQuestion> {
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
     * 删除题目管理
     *
     * @param questionId 题目管理主键
     * @return 结果
     */
    public int deleteOjQuestionByQuestionId(Long questionId);

    /**
     * 批量删除题目管理
     *
     * @param questionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjQuestionByQuestionIds(Long[] questionIds);
}
