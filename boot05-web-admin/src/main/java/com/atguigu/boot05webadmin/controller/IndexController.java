package com.atguigu.boot05webadmin.controller;

import com.atguigu.boot05webadmin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@Slf4j
@Controller
public class IndexController {
    //登录页面
    @GetMapping(value = {"/login","/"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String indexPage(User user, HttpSession session, Model model){
        //判断账户密码不为空
        if(StringUtils.hasLength(user.getUsername())&&"123456".equals(user.getPassword())){
            //把登陆成功的用户储存起来
            session.setAttribute("loginUser",user);
            //登陆成功，重定向到index.html页面；防止表单重复提交
            return "redirect:index";
        }else{
            model.addAttribute("msg","账号密码错误");
            //返回登录页面
            return "login";
        }
    }
    //去主页面
    @GetMapping("/index")
    public String mainPage(HttpSession session,Model model){
        log.info("当前方法是{}","mainPage");
        //是否登陆。使用拦截器机制或者过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser!=null){
//            return "index";
//        }else {
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
        return "index";
    }
}
