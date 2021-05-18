package com.atguigu.boot01.controller;

import com.atguigu.boot01.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {
    @ResponseBody
    @GetMapping("/hell")
    public FileSystemResource file(){
        FileSystemResource fileSystemResource = new FileSystemResource("D:\\springbootspace\\src\\main\\java\\com" +
                "\\atguigu\\boot01\\Boot01Application.java");
        fileSystemResource.getPath();
        return fileSystemResource;
    }
    @ResponseBody
    @GetMapping("/test/person")
    public Person person(){
        Person person = new Person();
        person.setAge(18);
        person.setUserName("zhangsan");
        person.setBirth(new Date());
        return person;
    }
}
