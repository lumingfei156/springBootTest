package com.springboot.server;

import com.springboot.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lulu
 * @since 2018/12/05
 * 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 如果用户没登陆过，就返回登陆页面
     * @param request ss
     * @param response ss
     * @param handler ss
     * @return s
     * @throws Exception s
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            response.sendRedirect("/springbootTest/login");
            flag = false;
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("页面渲染前,正在处理请求！！");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("请求已处理完！！");
    }

}
