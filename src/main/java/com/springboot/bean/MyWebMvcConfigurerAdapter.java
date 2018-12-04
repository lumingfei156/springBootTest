package com.springboot.bean;

import com.springboot.server.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author lulu
 * @since 2018/12/04
 * 默认的静态文件所在文件夹是static
 * 自定义静态文件所在文件夹，改成my
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    /**
     * 自定义静态文件存放位置
     * @param registry ss
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
        super.addResourceHandlers(registry);
    }

    /**
     * 将某一访问路径和某个页面绑定，即不通过controller直接访问某个页面
     * @param registry ss
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/goHelloWorld").setViewName("HelloWorld");
        registry.addViewController("/login").setViewName("login");
        super.addViewControllers(registry);
    }

    /**
     *实现拦截器效果
     * @param registry ss
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/userService/toLogin","/login");
        super.addInterceptors(registry);
    }
}
