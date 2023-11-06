package com.cloud.controller;

import com.cloud.pojo.Order;
import com.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
@RefreshScope
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public Res selectAll(){
        List<Order> list=orderService.selectAll();
        return new Res(list!=null?1:0,list);
    }

    @GetMapping("/{id}")
    public Res selectByID(@PathVariable long id){
        Order order=orderService.selectByID(id);
        return new Res(order!=null?1:0,order);
    }
}
