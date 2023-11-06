package com.cloud.service.impl;

import com.cloud.service.MailLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailLoginServiceImpl implements MailLoginService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${spring.mail.username}")
    private String from;
    private String subject="小马借贷";
    private String text;
    @Override
    public void sendMail(String to) {
        String num=createNum();
        text="验证码通知：" +
                "验证码"+num+"仅用于小马借贷账户登录，有效期60s,请勿泄露给他人，如非本人操作请忽略。";
        SimpleMailMessage MailMessage=new SimpleMailMessage();
        MailMessage.setTo(to);
        MailMessage.setFrom(from);
        MailMessage.setSubject(subject);
        MailMessage.setText(text);
        javaMailSender.send(MailMessage);

        ValueOperations ops=redisTemplate.opsForValue();
        ops.set(to,num);
    }

    @Override
    public String createNum() {
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            code.append(randomChar);
        }
        return code.toString();
    }

    @Override
    public boolean checkNum(String Mail,String num) {
        ValueOperations ops=redisTemplate.opsForValue();
        Object val=ops.get(Mail);
        return num.equals(val);
    }
}
