package com.zqp.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionHandler01 {
    @ExceptionHandler(value={ArithmeticException.class})
    public String mvexcept()
    {
        System.out.println("异常处理代码...");
        return "error";
    }
}
