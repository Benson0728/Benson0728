package com.cloud.controller;

import com.cloud.service.MailLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("MailLogin")
public class MailLoginController {
    @Autowired
    MailLoginService mailLoginService;

    @PostMapping
    public Res sendMail(String to) {
        try {
            mailLoginService.sendMail(to);
        } catch (Exception e) {
            return new Res(0, "验证码发送出错");
        }
        return new Res(1, "验证码发送成功");
    }

    @PutMapping
    public Res checkNum(String mail,String num){
        int code=mailLoginService.checkNum(mail,num)==true?1:0;
        return new Res(code,null);
    }

}

