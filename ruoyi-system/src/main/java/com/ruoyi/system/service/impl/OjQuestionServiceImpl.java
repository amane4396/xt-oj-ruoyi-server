package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjQuestionMapper;
import com.ruoyi.system.domain.OjQuestion;
import com.ruoyi.system.service.IOjQuestionService;

/**
 * 题目管理Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjQuestionServiceImpl extends ServiceImpl<OjQuestionMapper, OjQuestion> implements IOjQuestionService {
    @Autowired
    private OjQuestionMapper ojQuestionMapper;

    /**
     * 查询题目管理
     *
     * @param questionId 题目管理主键
     * @return 题目管理
     */
    @Override
    public OjQuestion selectOjQuestionByQuestionId(Long questionId) {
        return ojQuestionMapper.selectOjQuestionByQuestionId(questionId);
    }

    /**
     * 查询题目管理列表
     *
     * @param ojQuestion 题目管理
     * @return 题目管理
     */
    @Override
    public List<OjQuestion> selectOjQuestionList(OjQuestion ojQuestion) {
        return ojQuestionMapper.selectOjQuestionList(ojQuestion);
    }

    /**
     * 新增题目管理
     *
     * @param ojQuestion 题目管理
     * @return 结果
     */
    @Override
    public int insertOjQuestion(OjQuestion ojQuestion) {
        ojQuestion.setCreateTime(DateUtils.getNowDate());
        return ojQuestionMapper.insertOjQuestion(ojQuestion);
    }

    /**
     * 修改题目管理
     *
     * @param ojQuestion 题目管理
     * @return 结果
     */
    @Override
    public int updateOjQuestion(OjQuestion ojQuestion) {
        ojQuestion.setUpdateTime(DateUtils.getNowDate());
        return ojQuestionMapper.updateOjQuestion(ojQuestion);
    }

    /**
     * 批量删除题目管理
     *
     * @param questionIds 需要删除的题目管理主键
     * @return 结果
     */
    @Override
    public int deleteOjQuestionByQuestionIds(Long[] questionIds) {
        return ojQuestionMapper.deleteOjQuestionByQuestionIds(questionIds);
    }

    /**
     * 删除题目管理信息
     *
     * @param questionId 题目管理主键
     * @return 结果
     */
    @Override
    public int deleteOjQuestionByQuestionId(Long questionId) {
        return ojQuestionMapper.deleteOjQuestionByQuestionId(questionId);
    }
}
