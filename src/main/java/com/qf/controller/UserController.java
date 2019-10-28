package com.qf.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {


    // 登录
    @RequestMapping("/userlogin")
    public String  login(String username,String password) {

        // 获取去subject
        Subject subject = SecurityUtils.getSubject();
        // 制作令牌
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 记住我
        token.setRememberMe(true);
        // 登录
        subject.login(token);
        return "index";

    }


    // 登出
    @RequestMapping("/logout")
    public String logout(){
      SecurityUtils.getSubject().logout();
      return "index";
    }

}
