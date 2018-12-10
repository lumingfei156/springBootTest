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
 * 使用xml形式使用mybatis
 */
@RestController
@RequestMapping("/batisXmlLearnService")
public class BatisXmlLearnService {

    @Autowired
    private IlearnServer batisXmlLearnServer;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public int add(@RequestParam(required = false) String params){
        JSONObject jsonObject = JSON.parseObject(params);
        LearnBean learnBean = jsonObject.toJavaObject(LearnBean.class);
        return batisXmlLearnServer.add(learnBean);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public int delete(@RequestParam(required = false) String params){
        JSONObject jsonObject = JSON.parseObject(params);
        return batisXmlLearnServer.deleteByIds(jsonObject.getString("ids"));
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public int update(@RequestParam(required = false) String params){
        JSONObject jsonObject = JSON.parseObject(params);
        LearnBean learnBean = jsonObject.toJavaObject(LearnBean.class);
        return batisXmlLearnServer.update(learnBean);
    }

    @RequestMapping(value = "queryById",method = RequestMethod.POST)
    public String queryById(@RequestParam String params){
        JSONObject jsonObject = JSON.parseObject(params);
        LearnBean l = batisXmlLearnServer.queryById(jsonObject.getInteger("id"));
        return l.toString();
    }

    @RequestMapping(value = "queryByLike",method = RequestMethod.POST)
    public String queryByLike(@RequestParam String params){
        JSONObject jsonObject = JSON.parseObject(params);
        PageInfo<LearnBean> pageInfo = batisXmlLearnServer.queryByLike(jsonObject);
        StringBuilder sb = new StringBuilder("{");
        for (LearnBean temp : pageInfo.getList()){
            sb.append(temp.toString()).append(" ");
        }
        sb.append(" }");
        return sb.toString();
    }
}
