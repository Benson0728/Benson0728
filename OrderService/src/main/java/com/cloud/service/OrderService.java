package com.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.clients.UserServiceClients;
import com.cloud.dao.OrderDao;
import com.cloud.pojo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserServiceClients userServiceClients;

    public List<Order> selectAll(){
        return orderDao.selectList(null);
    }
@SentinelResource("selectByID")
    public Order selectByID(long id){
        Order order=orderDao.selectById(id);
        order.setUser(userServiceClients.selectByID(order.getUserId()));
        return order;
    }
}
