package com.cloud.controller;

import lombok.Data;
@Data
public class Res {
    private int code;
    private Object data;

    public Res(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Res() {
    }
}
