package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 题目批改得分对象 oj_score
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@TableName(resultMap = "com.ruoyi.system.mapper.OjScoreMapper.OjScoreResult")
public class OjScore extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 批改打分id
     */
    @TableId(value = "score_id", type = IdType.AUTO)
    private Long scoreId;

    /**
     * 提交记录id
     */
    @Excel(name = "提交记录id")
    private Long submitLogId;

    /**
     * 分数
     */
    @Excel(name = "分数")
    private Long score;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setSubmitLogId(Long submitLogId) {
        this.submitLogId = submitLogId;
    }

    public Long getSubmitLogId() {
        return submitLogId;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getScore() {
        return score;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("scoreId", getScoreId())
                .append("submitLogId", getSubmitLogId())
                .append("score", getScore())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
