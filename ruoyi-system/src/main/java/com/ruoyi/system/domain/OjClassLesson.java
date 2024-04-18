package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 课程班级关联对象 oj_class_lesson
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@TableName(resultMap = "com.ruoyi.system.mapper.OjClassLessonMapper.OjClassLessonResult")
public class OjClassLesson extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long lessonId;

    private Long classId;

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getClassId() {
        return classId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("lessonId", getLessonId())
                .append("classId", getClassId())
                .toString();
    }
}
