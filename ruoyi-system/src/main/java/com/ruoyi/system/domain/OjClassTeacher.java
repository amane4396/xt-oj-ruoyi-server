package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 班级教师关联对象 oj_class_teacher
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@TableName(resultMap = "com.ruoyi.system.mapper.OjClassTeacherMapper.OjClassTeacherResult")
public class OjClassTeacher extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 班级id
     */
    @Excel(name = "班级id")
    private Long ojClassId;

    /**
     * 教师id
     */
    @Excel(name = "教师id")
    private Long ojTeacherId;

    public void setOjClassId(Long ojClassId) {
        this.ojClassId = ojClassId;
    }

    public Long getOjClassId() {
        return ojClassId;
    }

    public void setOjTeacherId(Long ojTeacherId) {
        this.ojTeacherId = ojTeacherId;
    }

    public Long getOjTeacherId() {
        return ojTeacherId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("ojClassId", getOjClassId())
                .append("ojTeacherId", getOjTeacherId())
                .toString();
    }
}
