package com.anup.j6restapi.controller;

import com.anup.j6restapi.model.User;
import com.anup.j6restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    UserService userService;
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("users",userService.findAll());
        return "index";
    }
    @GetMapping("/delete/{id}")
    //@RequestMapping(method=RequestMethod.GET)
    public String deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user")  User user){
        userService.save(user);
        return "redirect:/";
    }
}
