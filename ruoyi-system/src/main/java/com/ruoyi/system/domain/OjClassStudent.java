package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 班级学生关联对象 oj_class_student
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@TableName(resultMap = "com.ruoyi.system.mapper.OjClassStudentMapper.OjClassStudentResult")
public class OjClassStudent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 班级id
     */
    @Excel(name = "班级id")
    private Long ojClassId;

    /**
     * 学生id
     */
    @Excel(name = "学生id")
    private Long ojStudentId;

    public void setOjClassId(Long ojClassId) {
        this.ojClassId = ojClassId;
    }

    public Long getOjClassId() {
        return ojClassId;
    }

    public void setOjStudentId(Long ojStudentId) {
        this.ojStudentId = ojStudentId;
    }

    public Long getOjStudentId() {
        return ojStudentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("ojClassId", getOjClassId())
                .append("ojStudentId", getOjStudentId())
                .toString();
    }
}
