package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OjScore;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 题目批改得分Service接口
 *
 * @author ruoyi
 * @date 2024-04-18
 */
public interface IOjScoreService extends IService<OjScore> {
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
     * 批量删除题目批改得分
     *
     * @param scoreIds 需要删除的题目批改得分主键集合
     * @return 结果
     */
    public int deleteOjScoreByScoreIds(Long[] scoreIds);

    /**
     * 删除题目批改得分信息
     *
     * @param scoreId 题目批改得分主键
     * @return 结果
     */
    public int deleteOjScoreByScoreId(Long scoreId);
}
