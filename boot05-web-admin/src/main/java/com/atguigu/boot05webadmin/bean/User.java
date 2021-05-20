package com.atguigu.boot05webadmin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor//全参构造器
@NoArgsConstructor//无参构造器
@Data
public class User {
    /**
     * 所有属性都应该在数据库中
     */
    //表示该数据在表中不存在
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;
//以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
