package com.cloud.service;

public interface MailLoginService {
    void sendMail(String to);
    String createNum();
    boolean checkNum(String Mail,String num);
}
