package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 课程管理对象 oj_lesson
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@TableName(resultMap = "com.ruoyi.system.mapper.OjLessonMapper.OjLessonResult")
public class OjLesson extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    @Excel(name = "课程id")
    @TableId(value = "lesson_id", type = IdType.AUTO)
    private Long lessonId;

    /**
     * 课程名称
     */
    @Excel(name = "课程名称")
    private String name;

    /**
     * 课程描述
     */
    @Excel(name = "课程描述")
    private String description;


    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getLessonId() {
        return lessonId;
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

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("lessonId", getLessonId())
                .append("name", getName())
                .append("description", getDescription())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
