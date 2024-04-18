package com.ruoyi.web.controller.oj;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.OjSubmitLog;
import com.ruoyi.system.service.IOjSubmitLogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xt
 * @date 2024/4/18 21:39:34
 */
@RestController
@RequestMapping("/test")
public class OjTestController {

    @Resource
    private IOjSubmitLogService iOjSubmitLogService;

    @Resource
    private ObjectMapper objectMapper;

    @PostMapping("/submit")
    public AjaxResult test(@RequestBody String requestBody) throws Exception{
        OjSubmitLog log = objectMapper.readValue(requestBody, OjSubmitLog.class);
        return iOjSubmitLogService.submit(log);
    }

}
