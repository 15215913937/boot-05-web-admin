package com.atguigu.boot05webadmin.service.impl;

import com.atguigu.boot05webadmin.bean.User;
import com.atguigu.boot05webadmin.mapper.UserMapper;
import com.atguigu.boot05webadmin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
