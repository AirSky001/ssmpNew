package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectException {
    @ExceptionHandler(Exception.class) //加.class可以分类别处理不同异常
    //所有的异常都通过这里统一处理
    public R doException(Exception ex) {
        ex.printStackTrace();
        return new R("服务器异常，请联系管理员");
    }
}
