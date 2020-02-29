package com.example.painting.controller;

import com.example.painting.pojo.User;
import com.example.painting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {


    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public String registration (){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser ( @Valid User user,
                            Model model ){
        if (!userService.addUser (user)) {
            model.addAttribute ("usernameError", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}

