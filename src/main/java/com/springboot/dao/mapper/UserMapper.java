package com.springboot.dao.mapper;

import com.springboot.util.MyMapper;
import com.springboot.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author lulu
 * @since 2018/12/11
 */
@Component(value = "uerMapper")
public interface UserMapper extends MyMapper<User> {
}