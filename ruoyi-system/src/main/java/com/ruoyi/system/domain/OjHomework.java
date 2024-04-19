package com.ruoyi.system.domain;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 作业管理对象 oj_homework
 *
 * @author ruoyi
 * @date 2024-04-18
 */
@TableName(resultMap = "com.ruoyi.system.mapper.OjHomeworkMapper.OjHomeworkResult")
public class OjHomework extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 作业id
     */
    @TableId(value = "homework_id", type = IdType.AUTO)
    private Long homeworkId;

    /**
     * 作业名称
     */
    @Excel(name = "作业名称")
    private String name;

    /**
     * 课程id
     */
    @Excel(name = "课程id")
    private Long lessonId;

    /**
     * 发布教师的id
     */
    @Excel(name = "发布教师的id")
    private Long teacherId;

    /**
     * 题目id列表，逗号分割
     */
    @Excel(name = "题目id列表，逗号分割")
    private String questionIds;

    public List<OjQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<OjQuestion> questionList) {
        this.questionList = questionList;
    }

    @TableField(exist = false)
    private List<OjQuestion> questionList;

    /**
     * 状态标志（开始，进行中，截止）
     */
    @Excel(name = "状态标志", readConverterExp = "开=始，进行中，截止")
    private Long status;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setQuestionIds(String questionIds) {
        this.questionIds = questionIds;
    }

    public String getQuestionIds() {
        return questionIds;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
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
                .append("homeworkId", getHomeworkId())
                .append("name", getName())
                .append("remark", getRemark())
                .append("lessonId", getLessonId())
                .append("teacherId", getTeacherId())
                .append("questionIds", getQuestionIds())
                .append("questionList", getQuestionList())
                .append("status", getStatus())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
