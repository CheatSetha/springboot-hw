package com.example.hwsb.controller;

import com.example.hwsb.model.Article;
import com.example.hwsb.model.User;
import com.example.hwsb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping
    String viewUser(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        System.out.println("user = "+users);
        return "pages/user/user";
    }

    @GetMapping("/{id}")
    String userDetail(@PathVariable("id") String id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        System.out.println("id == "+id);
        return "pages/user/user-detail";
    }
}
