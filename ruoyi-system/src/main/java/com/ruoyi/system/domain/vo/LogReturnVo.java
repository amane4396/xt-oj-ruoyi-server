package com.ruoyi.system.domain.vo;

import com.ruoyi.system.domain.OjSubmitLog;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xt
 * @date 2024/4/19 13:00:13
 */
@Slf4j
@Data
public class LogReturnVo {

    private String remark;

    private String runCondition;

    private String runTime;

}
