package com.cloud.controller;

import lombok.Data;

@Data
public class Res {
    private Integer flag;
    private Object data;

    public Res() {
    }

    public Res(Integer flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
