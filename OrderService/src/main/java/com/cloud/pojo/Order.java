package com.cloud.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_order")
public class Order {
    private long id;

    private long userId;
    private String name;
    private String price;
    private long num;
    @TableField(exist = false)
    private User user;

    public Order(long id, long userId, String name, String price, long num, User user) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.price = price;
        this.num = num;

        this.user = user;
    }

    public Order() {
    }


}
