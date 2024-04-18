package com.ruoyi.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.OjScore;

/**
 * 题目批改得分Mapper接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface OjScoreMapper extends BaseMapper<OjScore> {
    /**
     * 查询题目批改得分
     *
     * @param scoreId 题目批改得分主键
     * @return 题目批改得分
     */
    public OjScore selectOjScoreByScoreId(Long scoreId);

    /**
     * 查询题目批改得分列表
     *
     * @param ojScore 题目批改得分
     * @return 题目批改得分集合
     */
    public List<OjScore> selectOjScoreList(OjScore ojScore);

    /**
     * 新增题目批改得分
     *
     * @param ojScore 题目批改得分
     * @return 结果
     */
    public int insertOjScore(OjScore ojScore);

    /**
     * 修改题目批改得分
     *
     * @param ojScore 题目批改得分
     * @return 结果
     */
    public int updateOjScore(OjScore ojScore);

    /**
     * 删除题目批改得分
     *
     * @param scoreId 题目批改得分主键
     * @return 结果
     */
    public int deleteOjScoreByScoreId(Long scoreId);

    /**
     * 批量删除题目批改得分
     *
     * @param scoreIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOjScoreByScoreIds(Long[] scoreIds);
}
