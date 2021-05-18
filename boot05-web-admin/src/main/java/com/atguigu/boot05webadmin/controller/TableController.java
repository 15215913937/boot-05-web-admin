package com.atguigu.boot05webadmin.controller;

import com.atguigu.boot05webadmin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping("/basic")
    public String toBasic(){
        return "table/basic";
    }
    @GetMapping("/dynamic")
    public String toDynamic(Model model){
        //表格内遍历
        List<User> users = Arrays.asList(new User("张三", "123456"),
                new User("老王", "123789"),
                new User("阿花", "aaaaaa"),
                new User("阿狗", "adasdsa"));
        model.addAttribute("users",users);
        return "table/dynamic";
    }
    @GetMapping("/editable")
    public String toEditable(){
        return "table/editable";
    }
}
