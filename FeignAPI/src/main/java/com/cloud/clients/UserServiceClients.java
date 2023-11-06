package com.cloud.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cloud.pojo.User;

@FeignClient("UserService")
public interface UserServiceClients {
    @GetMapping("users/{id}")
    User selectByID(@PathVariable("id") long id);
}
