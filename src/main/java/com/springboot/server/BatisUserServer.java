package com.springboot.server;

import com.springboot.entity.User;
import com.springboot.dao.mapper.UserMapper;
import com.springboot.inter.IbatisUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lulu
 * @since 2018/12/11
 * 用于测试通用mapper
 */
@Service(value = "batisUserServer")
public class BatisUserServer implements IbatisUserServer{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
