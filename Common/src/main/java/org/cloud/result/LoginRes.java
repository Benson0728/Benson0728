package org.cloud.result;


import lombok.Data;

@Data
public class LoginRes {
    private int code;
    private String message;
    private Object data;
    private String token;

    public LoginRes() {
    }

    public LoginRes(int code,String token) {
        this.code = code;
        this.token=token;
    }

    public LoginRes LoginSuccess(String token){
        LoginRes loginRes=new LoginRes(1,token);
        return loginRes;
    }

    public LoginRes LoginFail(){
        LoginRes loginRes=new LoginRes();
        loginRes.setCode(0);
        return loginRes;
    }
}
