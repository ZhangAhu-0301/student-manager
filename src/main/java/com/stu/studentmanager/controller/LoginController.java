package com.stu.studentmanager.controller;
import com.stu.studentmanager.entity.User;
import com.stu.studentmanager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.annotation.Resource;
@Controller
public class LoginController {
    @Resource
    private UserService userService;
    @GetMapping("/")
    public String toLogin() {
        return "login";
    }
    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, Model model) {
        User user = userService.login(username, password);
        if (user == null) {
            model.addAttribute("msg", "账号或密码错误");
            return "login";
        }
        session.setAttribute("loginUser", user);
        return "redirect:/student/list";
    }
}