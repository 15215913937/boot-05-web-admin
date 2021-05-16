package com.atguigu.boot01.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor//无参构造器
@AllArgsConstructor//全参构造器
@Data//自动生成getset方法
@ToString
public class Pet {
    private String name;
    private Double weight;

}
