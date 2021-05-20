package com.atguigu.boot05webadmin;

import com.atguigu.boot05webadmin.bean.User;
import com.atguigu.boot05webadmin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {

        Long aLong = jdbcTemplate.queryForObject("select count(*) from cd", long.class);
        log.info("记录总数：{}",aLong);
    }
    @Autowired
    UserMapper userMapper;


    @Test
    void usermapper(){
        User user = userMapper.selectById(1);
        log.info("用户信息：{}",user);
    }

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        System.out.println(hello);
    }
}
