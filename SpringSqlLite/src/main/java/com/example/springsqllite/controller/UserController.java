package com.example.springsqllite.controller;


import com.example.springsqllite.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView save()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createuser");
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> readAllUsers(){
        return userService.readAllUsers();
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteAllUsers(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteAllUsers(){
        return userService.deleteAllUsers();
    }
}
