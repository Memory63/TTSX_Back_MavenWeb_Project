package com.sdh.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 16:56
 * @Version 1.0
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @PostMapping("login")
    @ResponseBody
    public String login(String username, String password, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(username+" "+password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        if (subject.isAuthenticated()) {
            session.setAttribute("username",username);
            System.out.println("登录成功"+username);
            return "1";
        }else{
            System.out.println("登录失败"+username);
            return null;
        }
    }

    @GetMapping("login")
    public String login(){
        return "redirect:/login.jsp";
    }

    @GetMapping("admin")
    public String admin(){
        return "WEB-INF/admin";
    }

    @GetMapping("logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:login";
    }

}
