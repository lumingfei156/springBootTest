package com.springboot.dao;

import com.springboot.entity.LearnBean;
import com.springboot.inter.Idao;
import com.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lulu
 * @since 2018/12/06
 * learnBean的增删该查实现
 */
@Repository("learnDao")
public class LearnDao implements Idao<LearnBean> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(LearnBean learnBean) {
        return jdbcTemplate.update("INSERT INTO learn_resource(author, title, url) VALUE (?,?,?)"
                                         ,learnBean.getAuthor()
                                         ,learnBean.getTitle()
                                         ,learnBean.getUrl());
    }

    @Override
    public int deleteByIds(String ids) {
        return jdbcTemplate.update("DELETE FROM learn_resource WHERE id IN (?)",ids);
    }

    @Override
    public int update(LearnBean learnBean) {
        return jdbcTemplate.update("UPDATE learn_resource SET author = ?,title = ?,url = ? WHERE id = ?"
                                    ,new Object[]{learnBean.getAuthor(),learnBean.getTitle(),learnBean.getUrl(),learnBean.getId()});
    }

    @Override
    public LearnBean queryById(int id) {
        List<LearnBean> list = jdbcTemplate.query("select * from learn_resource where id = ?"
                                                    ,new Object[]{id}
                                                    ,new BeanPropertyRowMapper(LearnBean.class));

        if (list != null && list.size() > 0){
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Page queryLearnResouceList(Map<String, Object> params) {
        String author = "author";
        String title = "title";
        StringBuilder sb = new StringBuilder();
        sb.append("select * from learn_resource where 1 = 1");
        if( params.get(author) != null && !((String)params.get(author)).isEmpty()){
            sb.append(" and author like '%").append((String)params.get("author")).append("%'");
        }
        if(params.get(title) != null && !((String)params.get(title)).isEmpty()){
            sb.append(" and title like '%").append((String)params.get("title")).append("%'");
        }
        return new Page(sb.toString(),
                    Integer.parseInt(params.get("page").toString()),
                    Integer.parseInt(params.get("rows").toString()),
                    jdbcTemplate);
    }

}
