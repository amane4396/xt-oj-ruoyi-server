package com.ruoyi.system.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.system.domain.OjLesson;
import com.ruoyi.system.domain.OjQuestion;
import com.ruoyi.system.domain.OjTeacher;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class HomeWorkVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 作业id
     */
    private Long homeworkId;

    /**
     * 作业名称
     */
    private String name;

    /**
     * 课程id
     */
    private Long lessonId;

    private OjLesson ojLesson;

    /**
     * 发布教师的id
     */
    private Long teacherId;

    /**
     * 题目id列表，逗号分割
     */
    private String questionIds;

    private List<OjQuestion> questionList;

    /**
     * 状态标志（开始，进行中，截止）
     */
    private Long status;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
}
