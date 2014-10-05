package com.dunkcoder.s3h3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dunkcoder.s3h3.entity.User;
import com.dunkcoder.s3h3.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String listUsers(ModelMap map) {
        map.addAttribute("user", new User());
        map.addAttribute("userList", userService.getUsers());

        return "userList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(value = "user") User user, BindingResult result) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") long userId) {
        userService.deleteUser(userId);
        return "redirect:/";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}