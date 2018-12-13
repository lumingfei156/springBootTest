package com.springboot.service;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lulu
 * @since 2018/12/12
 * 发生错误时修改修改返回路径
 */
@Controller
public class MyErrorService implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        int status401 = 401;
        int status404 = 404;
        int status403 = 403;
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == status401){
            return "/error/401";
        }else if(statusCode == status404){
            return "/error/404";
        }else if(statusCode == status403){
            return "/error/403";
        }else{
            return "/error/500";
        }

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
