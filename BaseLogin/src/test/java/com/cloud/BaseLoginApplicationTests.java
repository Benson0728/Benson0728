package com.cloud;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.Dao.BaseLoginMapper;
import com.cloud.service.BaseLoginService;
import org.cloud.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BaseLoginApplicationTests {
@Autowired
    BaseLoginMapper baseLoginMapper;
@Autowired
    BaseLoginService baseLoginService;
    @Test
    void contextLoads() {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_name","benson");
        System.out.println(baseLoginMapper.selectOne(queryWrapper));
    }
    @Test
    void test(){
        System.out.println(baseLoginService.select("benson"));
    }

    @Test
    void page(){
        IPage page=new Page(1,2);
        System.out.println(baseLoginMapper.selectPage(page,null).getRecords());
    }

}
