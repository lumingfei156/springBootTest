package com.springboot.inter;

import com.springboot.entity.User;

/**
 * @author lulu
 * @since 2018/12/11
 * 用于测试通用mapper
 */
public interface IbatisUserServer {
    /**
     * 通过Id查询
     * @param id s
     * @return s
     */
    User queryById(Integer id);

}
