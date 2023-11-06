package org.cloud.result;

import lombok.Data;

@Data
public class Res {
    private int code;
    private String message;
    private Object data;

    public Res success(){
        Res res=new Res(1);
        return res;
    }

    public Res success(Object data){
        Res res=new Res(1,data);
        return res;
    }

    public Res() {
    }

    public Res fail(){
        Res res=new Res(0);
        return res;
    }



    public Res(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Res(int code) {
        this.code = code;
    }


    public Res(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
