package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 班级管理对象 oj_class
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@Data
@TableName(resultMap = "com.ruoyi.system.mapper.OjClassMapper.OjClassResult")
public class OjClass extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 班级id
     */
    @TableId(value = "class_id", type = IdType.AUTO)
    private Long classId;

    /**
     * 班级名称
     */
    @Excel(name = "班级名称")
    private String className;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
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
                .append("classId", getClassId())
                .append("className", getClassName())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
