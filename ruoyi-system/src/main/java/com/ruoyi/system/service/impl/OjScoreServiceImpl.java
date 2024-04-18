package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OjScoreMapper;
import com.ruoyi.system.domain.OjScore;
import com.ruoyi.system.service.IOjScoreService;

/**
 * 题目批改得分Service业务层处理
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Service
public class OjScoreServiceImpl extends ServiceImpl<OjScoreMapper, OjScore> implements IOjScoreService {
    @Autowired
    private OjScoreMapper ojScoreMapper;

    /**
     * 查询题目批改得分
     *
     * @param scoreId 题目批改得分主键
     * @return 题目批改得分
     */
    @Override
    public OjScore selectOjScoreByScoreId(Long scoreId) {
        return ojScoreMapper.selectOjScoreByScoreId(scoreId);
    }

    /**
     * 查询题目批改得分列表
     *
     * @param ojScore 题目批改得分
     * @return 题目批改得分
     */
    @Override
    public List<OjScore> selectOjScoreList(OjScore ojScore) {
        return ojScoreMapper.selectOjScoreList(ojScore);
    }

    /**
     * 新增题目批改得分
     *
     * @param ojScore 题目批改得分
     * @return 结果
     */
    @Override
    public int insertOjScore(OjScore ojScore) {
        ojScore.setCreateTime(DateUtils.getNowDate());
        return ojScoreMapper.insertOjScore(ojScore);
    }

    /**
     * 修改题目批改得分
     *
     * @param ojScore 题目批改得分
     * @return 结果
     */
    @Override
    public int updateOjScore(OjScore ojScore) {
        ojScore.setUpdateTime(DateUtils.getNowDate());
        return ojScoreMapper.updateOjScore(ojScore);
    }

    /**
     * 批量删除题目批改得分
     *
     * @param scoreIds 需要删除的题目批改得分主键
     * @return 结果
     */
    @Override
    public int deleteOjScoreByScoreIds(Long[] scoreIds) {
        return ojScoreMapper.deleteOjScoreByScoreIds(scoreIds);
    }

    /**
     * 删除题目批改得分信息
     *
     * @param scoreId 题目批改得分主键
     * @return 结果
     */
    @Override
    public int deleteOjScoreByScoreId(Long scoreId) {
        return ojScoreMapper.deleteOjScoreByScoreId(scoreId);
    }
}
