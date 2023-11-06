package com.cloud.service;

import com.cloud.dao.UserDao;
import com.cloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> selectAll(){
        List<User> list= userDao.selectList(null);
        return list;
    }

    public User selectByID(long id){
        User user=userDao.selectById(id);
        return user;
    }

}
