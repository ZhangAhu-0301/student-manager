package com.stu.studentmanager.mapper;
import com.stu.studentmanager.entity.Student;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface StudentMapper {
    List<Student> list(@Param("name") String name);
    int add(Student s);
    int update(Student s);
    int del(Integer id);
    Student getById(Integer id);
}