package com.springboot.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lulu
 * @since 2018/12/13
 * 通过注解实现局部异常处理
 */
@Controller
@RequestMapping("/conErrorService")
public class ConErrorService {

    @RequestMapping("goError")
    public String goError(){
        String toReturn = "error";
        int i = 500/0;
        return toReturn;
    }

    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e){
        return "/controllerHandler";
    }
}
