package com.springboot.inter;

import com.github.pagehelper.PageInfo;
import com.springboot.entity.LearnBean;
import com.springboot.util.Page;

import java.util.Map;

/**
 * @author lulu
 * @since 2018/12/06
 * 通过JdbcTemplate连接数据库
 */
public interface IlearnServer {
    /**
     * 增
     * @param l s
     * @return s
     */
    int add(LearnBean l);

    /**
     * 删
     * @param ids s
     * @return s
     */
    int deleteByIds(String ids);

    /**
     * 改
     * @param l s
     * @return s
     */
    int update(LearnBean l);

    /**
     * 查
     * @param id s
     * @return s
     */
    LearnBean queryById(int id);

    /**
     * 查
     * @param params s
     * @return s
     */
    Page queryLearnResouceList(Map<String,Object> params);

    /**
     * 使用分页插件的查询
     * @param params s
     * @return s
     */
    PageInfo<LearnBean> queryByLike(Map<String,Object> params);

}
