package com.zqp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhaoss
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(String uname, String pwd, HttpServletRequest req){
        // 如果登录成功，跳转到项目首页：
        if ("lili".equals(uname) && "123123".equals(pwd)){
            // 登录成功，就将用户名字放入session中：
            req.getSession().setAttribute("uname",uname);
            return "first";
        }
        return "redirect:/login.html";
    }
}
