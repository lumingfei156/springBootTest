package com.springboot.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.entity.LearnBean;
import com.springboot.inter.IlearnServer;
import com.springboot.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;


/**
 * @author lulu
 * @since 2018/12/06
 * 实现增删改查
 */
@RestController
@RequestMapping("/learnService")
public class LearnService {
    @Autowired
    private IlearnServer learnServer;

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public int add(@RequestParam(required = false) String params){
        JSONObject jsonObject = JSON.parseObject(params);
        LearnBean learnBean = jsonObject.toJavaObject(LearnBean.class);
        return learnServer.add(learnBean);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public int delete(@RequestParam(required = false) String params){
        JSONObject jsonObject = JSON.parseObject(params);
        return learnServer.deleteByIds(jsonObject.getString("ids"));
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public int update(@RequestParam(required = false) String params){
        JSONObject jsonObject = JSON.parseObject(params);
        LearnBean learnBean = jsonObject.toJavaObject(LearnBean.class);
        return learnServer.update(learnBean);
    }

    @RequestMapping(value = "queryById",method = RequestMethod.POST)
    public String queryById(@RequestParam String params){
        JSONObject jsonObject = JSON.parseObject(params);
        LearnBean l = learnServer.queryById(jsonObject.getInteger("id"));
        return l.toString();
    }

    @RequestMapping(value = "queryByLike",method = RequestMethod.POST)
    public String queryByLike(@RequestParam String params){
        JSONObject jsonObject = JSON.parseObject(params);
        Page page = learnServer.queryLearnResouceList(jsonObject);
        StringBuilder sb = new StringBuilder("{ ");
        for (Map<String,Object> temp : page.getResultList()){
            Set<String> keyset = temp.keySet();
            sb.append(" [ ");
            for (String keyStr : keyset){
                sb.append(keyStr).append(" : ");
                sb.append(temp.get(keyStr).toString()).append(" , ");
            }
            sb.append(" ] ");
        }
        sb.append(" }");
        return sb.toString();
    }


}
