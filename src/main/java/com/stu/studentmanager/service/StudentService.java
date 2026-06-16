package com.stu.studentmanager.service;
import com.stu.studentmanager.entity.Student;
import com.stu.studentmanager.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import java.util.List;
@Service
public class StudentService {
    @Resource
    private StudentMapper studentMapper;
    public List<Student> getList(String name) {
        return studentMapper.list(name);
    }
    public int addStudent(Student s) {
        return studentMapper.add(s);
    }
    public int updateStudent(Student s) {
        return studentMapper.update(s);
    }
    public int deleteStudent(Integer id) {
        return studentMapper.del(id);
    }
    public Student getStudentById(Integer id) {
        return studentMapper.getById(id);
    }
}