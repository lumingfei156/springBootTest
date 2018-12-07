package com.springboot.inter;

import com.springboot.util.Page;

import java.util.Map;

/**
 * DAO类,定义了普通的DAO操作,增删改查
 * @author lulu
 * @since 2018/12/06
 * @param <T>
 */
public interface Idao<T> {
    /**
     * 增加
     * @param t 实体类
     * @return s
     */
     int add(T t);

    /**
     * 根据id删除
     * @param ids s
     * @return s
     */
     int deleteByIds(String ids);

    /**
     * 更新实体类
     * @param t 实体类
     * @return s
     */
     int update(T t);

    /**
     * 通过id查询
     * @param id s
     * @return s
     */
    T queryById(int id);

    /**
     * 获取多行记录
     * @param params s
     * @return s
     */
    Page queryLearnResouceList(Map<String,Object> params);

}
