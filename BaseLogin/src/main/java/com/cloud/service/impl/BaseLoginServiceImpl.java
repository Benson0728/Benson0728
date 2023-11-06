package com.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.Dao.BaseLoginMapper;
import com.cloud.service.BaseLoginService;
import org.cloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BaseLoginServiceImpl implements BaseLoginService {
   @Autowired
   private BaseLoginMapper baseLoginMapper;
    @Override
    public User select(String username) {
        QueryWrapper<User> qw=new QueryWrapper<>();
        qw.eq("user_name",username);
        User user=baseLoginMapper.selectOne(qw);
        return user;
    }
}
