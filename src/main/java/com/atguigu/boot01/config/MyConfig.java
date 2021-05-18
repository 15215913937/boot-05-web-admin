package com.atguigu.boot01.config;

import com.atguigu.boot01.bean.Car;
import com.atguigu.boot01.bean.Pet;
import com.atguigu.boot01.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
@ConditionalOnMissingBean(name = "tom")
@Import({User.class})
@Configuration
@EnableConfigurationProperties(Car.class)
//1、开启Car属性配置功能
//2、把这个Car这个组件自动注册到容器中
public class MyConfig {

//    @Bean
//    public User user01(){
//        User zhangsan = new User("zhangsan",18);
//        zhangsan.setPet(tomcatPet());
//        return zhangsan;
//    }
//    @Bean(name = "tom")
//    public Pet tomcatPet(){
//        return new Pet("tomcat",30.0);
//    }
}
