package com.zqp.exceptionhandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @Author: zhaoss
 */

@Configuration
public class ExceptionHandler02 {
    @Bean
    public SimpleMappingExceptionResolver getSME(){
        SimpleMappingExceptionResolver s = new SimpleMappingExceptionResolver();
        Properties p = new Properties();
        p.put("java.lang.ArithmeticException","myerror");
        s.setExceptionMappings(p);
        return s;
    }

}
