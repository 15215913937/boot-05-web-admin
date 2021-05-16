package com.atguigu.boot01.bean;

import lombok.*;

//@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode//重写hashcode方法
public class User {
    private String name;
    private Integer age;
    private Pet pet;

    public User(String name,Integer age){
        this.name=name;
        this.age=age;
    }


}
