package com.springboot.service;

import com.springboot.bean.ThymeleafBean;
import com.springboot.inter.IthymeleafServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author lulu
 * @since 2018/12/04
 * 用于测试thymeleaf
 */
@Controller
@RequestMapping("/thymeleafService")
public class ThymeleafService {

    @Autowired
    private IthymeleafServer thymeleafServer;

    @RequestMapping("index")
    public ModelAndView index(){
        List<ThymeleafBean> list = thymeleafServer.index();
        ModelAndView modelAndView = new ModelAndView("/thymeleaf");
        modelAndView.addObject("learnList",list);
        return modelAndView;
    }

}
