package com.springboot.service;

import com.springboot.inter.IuserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author lulu
 * @since 2018/12/03
 * userServer的service层
 */
@RestController
@RequestMapping("/userService")
public class UserService {

    @Autowired
    private IuserServer userServer;

    @RequestMapping(method = RequestMethod.GET, value = "useConfig")
    public String useConfig(){
        return userServer.useConfig();
    }

    @RequestMapping(method = RequestMethod.GET, value = "useConfigByBean")
    public String useConfigByBean(){
        String s = userServer.useConfigByBean();
        System.out.println(s);
        return s;
    }

    @RequestMapping(method = RequestMethod.POST,value = "goLogin")
    public Map<String,String> login(HttpServletRequest request, HttpServletResponse response){
        return userServer.login(request);
    }

}