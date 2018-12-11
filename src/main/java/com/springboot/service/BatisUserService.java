package com.springboot.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.inter.IbatisUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lulu
 * @since 2018/12/11
 * 用于测试通用mapper
 */
@RestController
@RequestMapping("/batisUserService")
public class BatisUserService {
    @Autowired
    private IbatisUserServer batisUserServer;

    @RequestMapping(value = "queryById",method = RequestMethod.POST)
    public String queryById(@RequestParam String params){
        JSONObject jsonObject = JSON.parseObject(params);
        return batisUserServer.queryById(jsonObject.getInteger("id")).toString();
    }

}
