package com.atguigu.boot05webadmin.controller;

import com.atguigu.boot05webadmin.bean.User;
import com.atguigu.boot05webadmin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @Autowired
    UserService userService;

    @GetMapping("/basic")
    public String toBasic(){
        return "table/basic";
    }
    //删除用户
    /**
     * 效果：删除时仍然在删除的那一页
     *    1、点击删除会带上pn参数，带到GetMapping请求中
     *    2、请求拿到pn参数
     *    3、重定向时又带上pn
     */

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);
        ra.addAttribute("pn",pn);

        return "redirect:/dynamic";
    }

    @GetMapping("/dynamic")
    public String toDynamic(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                            Model model){

        List<User> list = userService.list();
//        model.addAttribute("users",list);
        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);
        //分页查询结果
        Page<User> page = userService.page(userPage, null);
        //当前页
        long current = page.getCurrent();
        //总页数
        long pages = page.getPages();
        //总记录
        long total = page.getTotal();

        List<User> records = page.getRecords();
        model.addAttribute("page",page);

        return "table/dynamic";
    }
    @GetMapping("/editable")
    public String toEditable(){
        return "table/editable";
    }
}
