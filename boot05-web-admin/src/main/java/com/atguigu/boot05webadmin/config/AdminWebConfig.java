package com.atguigu.boot05webadmin.config;

import com.atguigu.boot05webadmin.interceptor.LoginInterceptor;
import com.atguigu.boot05webadmin.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1、编写一个拦截器实现HandlerTntercepor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则（如果是拦截所有（/**），静态资源也会被拦截）
 *
 * @EnableWebMvc  全面接管
 * 1、静态资源、视图解析器、欢迎页。。。全部失效
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /**
     * Filter、Interceptr几乎拥有相同的功能，区别在哪
     * 1、Filter是Servlet定义的原生组件。脱离Spring应用也能使用
     * 2、Interceptor是Spring定义的接口。可以使用Spring的自动装配功能
     */
    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         *访问 /aa/**所有请求去classpath:/static/下面进行匹配
         */
        registry.addResourceHandler("/aa/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//所有资源请求都被拦截，包括静态static资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**");//放行的请求
//new 的话自动注入的组件无法用，只有容器中的组件 spring才会解析这些注解，应该从容器中拿
        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**");
    }
}
