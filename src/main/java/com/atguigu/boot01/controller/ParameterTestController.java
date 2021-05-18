package com.atguigu.boot01.controller;

import com.atguigu.boot01.bean.Person;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
    @PostMapping("/saveuser")
    public Person saveuser(Person person){
        return person;
    }


    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String user,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String UserAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params
    ){
        HashMap<String, Object> map = new HashMap<>();
//        map.put("id",id);
//        map.put("username",user);
//        map.put("pv",pv);
//        map.put("UserAgent",UserAgent);
//        map.put("header",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        return map;
    }
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        HashMap<String, Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }
    ///cars/sell;low=34;brand=byd,audi,yd
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") String low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }
    ///boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("BossAge",bossAge);
        map.put("EmpAge",empAge);
        return map;
    }
}
