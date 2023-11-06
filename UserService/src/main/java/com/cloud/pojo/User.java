package com.cloud.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("tb_user")
public class User{
        private long id;
        private String username;
        private String address;

        public User() {
        }

        public User(long id, String username, String address) {
                this.id = id;
                this.username = username;
                this.address = address;
        }
}
