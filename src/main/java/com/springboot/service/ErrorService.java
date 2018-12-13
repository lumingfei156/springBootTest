package com.springboot.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lulu
 * @since 2018/12/12
 * 用来测试全局异常处理
 */
@Controller
@RequestMapping(value = "/errorService")
public class ErrorService {

    @RequestMapping(value = "goFive",method = RequestMethod.GET)
    public ModelAndView goFive(){
        //看会不会跳到500的页面中
        int i  = 500/0;
        return new ModelAndView("login");
    }


}
