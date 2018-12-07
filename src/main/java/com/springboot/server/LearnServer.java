package com.springboot.server;

import com.springboot.dao.LearnDao;
import com.springboot.entity.LearnBean;
import com.springboot.inter.IlearnServer;
import com.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author lulu
 * @since 2018/12/06
 * 实现增删改查
 */
@Service("learnServer")
public class LearnServer implements IlearnServer{
    @Autowired
    private LearnDao learnDao;

    @Override
    public int add(LearnBean l) {
        return learnDao.add(l);
    }

    @Override
    public int deleteByIds(String ids) {
        return learnDao.deleteByIds(ids);
    }

    @Override
    public int update(LearnBean l) {
        return learnDao.update(l);
    }

    @Override
    public LearnBean queryById(int id) {
        return learnDao.queryById(id);
    }

    @Override
    public Page queryLearnResouceList(Map<String, Object> params) {
        return learnDao.queryLearnResouceList(params);
    }
}
