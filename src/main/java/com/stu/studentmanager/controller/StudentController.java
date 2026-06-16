package com.stu.studentmanager.controller;
import com.stu.studentmanager.entity.Student;
import com.stu.studentmanager.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.annotation.Resource;
import java.util.List;
@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    @GetMapping("/list")
    public String list(@RequestParam(required = false) String name, Model model, HttpSession session) {
        if (session.getAttribute("loginUser") == null) {
            return "redirect:/";
        }
        List<Student> list = studentService.getList(name);
        model.addAttribute("list", list);
        model.addAttribute("searchName", name);
        return "student/list";
    }
    @GetMapping("/toAdd")
    public String toAdd() {
        return "student/add";
    }
    @PostMapping("/add")
    public String add(Student student) {
        studentService.addStudent(student);
        return "redirect:/student/list";
    }
    @GetMapping("/toEdit")
    public String toEdit(Integer id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student/edit";
    }
    @PostMapping("/update")
    public String update(Student student) {
        studentService.updateStudent(student);
        return "redirect:/student/list";
    }
    @GetMapping("/del")
    public String del(Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }
}