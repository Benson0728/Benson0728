package org.cloud.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {
    private String userName;
    private String passWord;
    private String mailAddr;
    private String phoneNum;

    public User() {
    }

    public User(String userName, String passWord, String mailAddr, String phoneNum) {
        this.userName = userName;
        this.passWord = passWord;
        this.mailAddr = mailAddr;
        this.phoneNum = phoneNum;
    }
}
