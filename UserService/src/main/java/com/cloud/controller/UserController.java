package com.cloud.controller;

import com.cloud.pojo.User;
import com.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping
    public Res selectAll(){
        List<User> list=new ArrayList<>();
        list=userService.selectAll();
        Res res=new Res((list!=null)?1:0,list);
        return res;
    }

    @GetMapping("/{id}")
    public User selectByID(@PathVariable long id){

        return userService.selectByID(id);
    }
}
