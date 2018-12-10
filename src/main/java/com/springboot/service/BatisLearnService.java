package com.springboot.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.springboot.entity.LearnBean;
import com.springboot.inter.IlearnServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lulu
 * @since 2018/12/10
 * mybatis操作数据库
 */
@RestController
@RequestMapping("/batisLearnService")
public class BatisLearnService {

    @Autowired
    private IlearnServer batisLearnServer;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public int add(@RequestParam(required = false) String params){
        JSONObject jsonObject = JSON.parseObject(params);
        LearnBean learnBean = jsonObject.toJavaObject(LearnBean.class);
        return batisLearnServer.add(learnBean);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public int delete(@RequestParam(required = false) String params){
        JSONObject jsonObject = JSON.parseObject(params);
        return batisLearnServer.deleteByIds(jsonObject.getString("ids"));
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public int update(@RequestParam(required = false) String params){
        JSONObject jsonObject = JSON.parseObject(params);
        LearnBean learnBean = jsonObject.toJavaObject(LearnBean.class);
        return batisLearnServer.update(learnBean);
    }

    @RequestMapping(value = "queryById",method = RequestMethod.POST)
    public String queryById(@RequestParam String params){
        JSONObject jsonObject = JSON.parseObject(params);
        LearnBean l = batisLearnServer.queryById(jsonObject.getInteger("id"));
        return l.toString();
    }

    @RequestMapping(value = "queryByLike",method = RequestMethod.POST)
    public String queryByLike(@RequestParam String params){
        JSONObject jsonObject = JSON.parseObject(params);
        PageInfo<LearnBean> pageInfo = batisLearnServer.queryByLike(jsonObject);
        StringBuilder sb = new StringBuilder("{");
        for (LearnBean temp : pageInfo.getList()){
            sb.append(temp.toString()).append(" ");
        }
        sb.append(" }");
        return sb.toString();
    }
}
