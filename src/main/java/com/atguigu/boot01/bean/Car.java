package com.atguigu.boot01.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Data
@ToString
//@Component//将组件加入到容器中
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;

}
