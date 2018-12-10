package com.springboot.inter;

import com.springboot.entity.LearnBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author lulu
 * @since 2018/12/10
 * 使用xml方式配置的mapper
 */
@Component(value = "learnXmlDAO")
public interface IlearnXmlDAO {
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
    int deleteByIds(String[] ids);

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
     * 模糊查询
     * @param param s
     * @return s
     */
    List<LearnBean> queryByLike(Map<String,String> param);


}
