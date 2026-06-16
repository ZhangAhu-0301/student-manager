package com.stu.studentmanager.mapper;
import com.stu.studentmanager.entity.User;
import org.apache.ibatis.annotations.Param;
public interface UserMapper {
    User login(@Param("username") String username, @Param("pwd") String pwd);
}