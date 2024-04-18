package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 题目样例对象 oj_case
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@TableName(resultMap = "com.ruoyi.system.mapper.OjCaseMapper.OjCaseResult")
public class OjCase extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 样例id
     */
    @TableId(value = "case_id", type = IdType.AUTO)
    private Long caseId;

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 输入
     */
    @Excel(name = "输入")
    private String input;

    /**
     * 答案样例
     */
    @Excel(name = "答案样例")
    private String result;

    @TableField(exist = false)
    private OjQuestion question;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
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
                .append("caseId", getCaseId())
                .append("questionId", getQuestionId())
                .append("input", getInput())
                .append("result", getResult())
                .append("question", getQuestion())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }

    public OjQuestion getQuestion() {
        return question;
    }

    public void setQuestion(OjQuestion question) {
        this.question = question;
    }
}
