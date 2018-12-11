package com.springboot.server;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.entity.LearnBean;
import com.springboot.inter.IlearnServer;
import com.springboot.dao.mapper.IlearnXmlDAO;
import com.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lulu
 * @since 2018/12/10
 * 使用xml形式使用mybatis
 */
@Service(value = "batisXmlLearnServer")
public class BatisXmlLearnServer implements IlearnServer{
    @Autowired
    private IlearnXmlDAO learnXmlDAO;

    @Override
    public int add(LearnBean l) {
        return learnXmlDAO.add(l);
    }

    @Override
    public int deleteByIds(String ids) {
        String[] idArray = ids.split(" ");
        return learnXmlDAO.deleteByIds(idArray);
    }

    @Override
    public int update(LearnBean l) {
        return learnXmlDAO.update(l);
    }

    @Override
    public LearnBean queryById(int id) {
        return learnXmlDAO.queryById(id);
    }

    @Override
    public Page queryLearnResouceList(Map<String, Object> params) {
        return null;
    }

    @Override
    public PageInfo<LearnBean> queryByLike(Map<String, Object> params) {
        //params转换成<String,String>类型的map
        Map<String,String> strMap = new HashMap<>(10);
        Set<String> keySet = params.keySet();
        for (String key : keySet){
            strMap.put(key, (String) params.get(key));
        }
        // startPage(第几页, 多少条数据)
        PageHelper.startPage(1, 5);
        List<LearnBean> list = learnXmlDAO.queryByLike(strMap);
        return new PageInfo<>(list);
    }

}
