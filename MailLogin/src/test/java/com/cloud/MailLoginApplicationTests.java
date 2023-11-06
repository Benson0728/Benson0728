package com.cloud;

import com.cloud.service.MailLoginService;
import org.cloud.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class MailLoginApplicationTests {
@Autowired
private MailLoginService mailLoginService;

@Autowired
    RedisTemplate redisTemplate;
    @Test
    void sendMail() {
        mailLoginService.sendMail("814498472@qq.com");
    }

    @Test
    void createNum(){
        System.out.println(mailLoginService.createNum());
    }

    @Test
    void redis(){
        ValueOperations ops=redisTemplate.opsForValue();
        ops.set("name2","ben");
    }
    @Test
    void redisget(){
        ValueOperations ops=redisTemplate.opsForValue();
        User user= (User) ops.get("test");
        System.out.println(user.toString());
    }

    @Test
    void redisSet(){
        User user=new User("ben","122212","ewddwd","wqw");
        redisTemplate.opsForValue().set("test",user);
    }

}
