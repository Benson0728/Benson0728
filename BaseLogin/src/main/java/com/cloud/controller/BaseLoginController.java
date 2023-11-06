package com.cloud.controller;

import com.cloud.service.BaseLoginService;
import com.cloud.utils.JWTutil;
import org.cloud.result.LoginRes;
import org.cloud.result.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("UserLogin")
public class BaseLoginController {
    @Autowired
    private BaseLoginService baseLoginService;

    LoginRes loginRes=new LoginRes();

    @PostMapping
    public LoginRes login(String username,String password){
        if(password.equals(baseLoginService.select(username).getPassWord())){
            return loginRes.LoginSuccess(JWTutil.createToken(username));
        };
        return loginRes.LoginFail();



    }
}
