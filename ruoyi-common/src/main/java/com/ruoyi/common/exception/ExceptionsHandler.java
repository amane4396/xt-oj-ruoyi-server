package com.ruoyi.common.exception;

import com.ruoyi.common.core.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author DH
 * @create 2022-06-20
 */
@Slf4j
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ActiveException.class)
    @ResponseBody
    public AjaxResult handleException(ActiveException ex) {
        return AjaxResult.error(ex.getMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResult handleException(Exception ex) {
        log.error(ex.toString(), ex);
        return AjaxResult.error();
    }
}
