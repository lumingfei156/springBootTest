package com.springboot.inter;

import com.springboot.bean.ThymeleafBean;

import java.util.List;

/**
 * @author lulu
 * @since 2018/12/04
 * 用于测试thymeleaf
 */
public interface IthymeleafServer {
    /**
     * 返回一个bean给service层
     * @return bean
     */
    List<ThymeleafBean> index();
}
