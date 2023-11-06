package com.cloud.pojo;

import lombok.Data;

import javax.sql.rowset.spi.SyncResolver;

@Data
public class User {
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
