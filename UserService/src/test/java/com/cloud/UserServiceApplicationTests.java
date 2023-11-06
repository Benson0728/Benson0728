package com.cloud;

import com.cloud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {
@Autowired
private UserService userService;
    @Test
    void contextLoads() {
        System.out.println(userService.selectAll());
    }

}
