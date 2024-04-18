package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 提交样例记录对象 oj_submit_log
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@TableName(resultMap = "com.ruoyi.system.mapper.OjSubmitLogMapper.OjSubmitLogResult")
public class OjSubmitLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 提交记录id
     */
    @TableId(value = "submit_log_id", type = IdType.AUTO)
    private Long submitLogId;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 通过样例的数量
     */
    @Excel(name = "通过样例的数量")
    private Long passNum;

    /**
     * 状态(accept, failed, overtime)
     */
    @Excel(name = "状态(accept, failed, overtime)")
    private String status;

    /**
     * 提交内容
     */
    @Excel(name = "提交内容")
    private String code;

    /**
     * 运行用时
     */
    @Excel(name = "运行用时")
    private String runTime;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setSubmitLogId(Long submitLogId) {
        this.submitLogId = submitLogId;
    }

    public Long getSubmitLogId() {
        return submitLogId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setPassNum(Long passNum) {
        this.passNum = passNum;
    }

    public Long getPassNum() {
        return passNum;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getRunTime() {
        return runTime;
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
                .append("submitLogId", getSubmitLogId())
                .append("studentId", getStudentId())
                .append("questionId", getQuestionId())
                .append("passNum", getPassNum())
                .append("status", getStatus())
                .append("code", getCode())
                .append("remark", getRemark())
                .append("runTime", getRunTime())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
