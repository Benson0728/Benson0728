package com.cloud;

import com.cloud.clients.UserServiceClients;
import com.cloud.dao.OrderDao;
import com.cloud.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceApplicationTests {
@Autowired
private OrderService orderService;
@Autowired
private OrderDao orderDao;

@Autowired
private UserServiceClients userServiceClients;
    @Test
    void contextLoads() {
        System.out.println(orderService.selectByID(103).getUserId());
        System.out.println(orderDao.selectById(103).getUserId());
    }

}
