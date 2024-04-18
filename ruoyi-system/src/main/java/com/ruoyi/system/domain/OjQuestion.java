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
 * 题目管理对象 oj_question
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@TableName(resultMap = "com.ruoyi.system.mapper.OjQuestionMapper.OjQuestionResult")
public class OjQuestion extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 题目id
     */
    @TableId(value = "question_id", type = IdType.AUTO)
    private Long questionId;

    @Excel(name = "课程id")
    private Long lessonId;

    @TableField(exist = false)
    private OjLesson lesson;

    /**
     * 题目名称
     */
    @Excel(name = "题目名称")
    private String name;

    /**
     * 题目描述
     */
    @Excel(name = "题目描述")
    private String description;

    /**
     * 模板内容
     */
    @Excel(name = "模板内容")
    private String template;

    /**
     * 题目难度等级
     */
    @Excel(name = "题目难度等级")
    private String difficultyLevel;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public OjLesson getLesson() {
        return lesson;
    }

    public void setLesson(OjLesson lesson) {
        this.lesson = lesson;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
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
                .append("questionId", getQuestionId())
                .append("lessonId", getLessonId())
                .append("lesson", getLesson())
                .append("name", getName())
                .append("description", getDescription())
                .append("template", getTemplate())
                .append("difficultyLevel", getDifficultyLevel())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }
}
