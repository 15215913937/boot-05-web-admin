package com.atguigu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
    @GetMapping("/atguigu")
    public String atguigu(Model model){
        //model中的数据会自动被放在请求域中request.setAttribute("a",aa)
        model.addAttribute("msg","hello,guigu");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
