package com.zqp.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author: zhaoss
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果登录过，就放行
        if (request.getSession().getAttribute("uname") != null){
            return true;
        }

        // 如果没有登陆过，先登录：
        response.sendRedirect("login.html");
        return false;// 如果没有登录过，就不放行
    }
}
