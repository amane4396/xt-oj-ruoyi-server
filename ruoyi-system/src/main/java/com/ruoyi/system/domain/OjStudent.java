package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 学生管理对象 oj_student
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@TableName(resultMap = "com.ruoyi.system.mapper.OjStudentMapper.OjStudentResult")
public class OjStudent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    @TableId(value = "student_id", type = IdType.AUTO)
    private Long studentId;

    /**
     * 关联sys_user id
     */
    private Long userId;

    /**
     * 学号
     */
    @Excel(name = "学号")
    private String no;

    /**
     * 专业
     */
    @Excel(name = "专业")
    private String major;

    private SysUser sysUser;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
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
                .append("studentId", getStudentId())
                .append("userId", getUserId())
                .append("no", getNo())
                .append("sysUser", getSysUser())
                .append("major", getMajor())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .toString();
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
