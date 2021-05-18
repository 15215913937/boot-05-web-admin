package com.atguigu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequsetController {
    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request){

        request.setAttribute("msg","成功了。。。");
        request.setAttribute("code",800);
        return "forward:/success";//转发到/success请求
    }
    @GetMapping("/params")
    public String testParam(Map<String,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("hello","world666");
        model.addAttribute("world","hello");
        request.setAttribute("message","HelloWorld");
        Cookie cookie = new Cookie("c1","v1");
        response.addCookie(cookie);
        return "forward:/success";
    }


    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg",required = false) String msg,
                       @RequestAttribute(value = "code",required = false) Integer code,
                       HttpServletRequest request){
        Object code1 = request.getAttribute("code");
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        Map<String,Object> map = new HashMap<>();
        map.put("reqMethod_code",code1);
        map.put("annotation",msg);
        map.put("hello",hello);
        map.put("world",world);
        map.put("message",message);
        return map;
    }
}
