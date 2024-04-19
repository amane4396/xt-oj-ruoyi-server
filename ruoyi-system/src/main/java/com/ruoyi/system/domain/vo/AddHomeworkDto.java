package com.ruoyi.system.domain.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author xt
 * @date 2024/4/19 13:20:38
 */

@Slf4j
@Data
public class AddHomeworkDto {

    /**
     * 题目id，用 ‘，’ 分隔
     */
    private String questionIds;

    /**
     * 备注
     */
    private String remark;

    /**
     * 课程id
     */
    private Long lessonId;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;



}
