package com.stu.studentmanager.service;
import com.stu.studentmanager.entity.User;
import com.stu.studentmanager.mapper.UserMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }
}