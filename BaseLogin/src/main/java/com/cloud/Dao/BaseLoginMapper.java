package com.cloud.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.cloud.pojo.User;
@Mapper
public interface BaseLoginMapper extends BaseMapper<User> {
}
