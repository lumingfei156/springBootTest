package com.springboot.server;


import com.springboot.bean.ThymeleafBean;
import com.springboot.inter.IthymeleafServer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lulu
 * @since 2018/12/04
 * 用于用于进行Thymeleaf测试
 */
@Component("thymeleafServer")
public class ThymeleafServer implements IthymeleafServer{

    @Override
    public List<ThymeleafBean> index() {
        List<ThymeleafBean> learnList = new ArrayList<>();
        ThymeleafBean bean =new ThymeleafBean("官方参考文档","Spring Boot Reference Guide","http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        learnList.add(bean);
        bean =new ThymeleafBean("官方SpriongBoot例子","官方SpriongBoot例子","https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        learnList.add(bean);
        bean =new ThymeleafBean("龙国学院","Spring Boot 教程系列学习","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new ThymeleafBean("嘟嘟MD独立博客","Spring Boot干货系列 ","http://tengj.top/");
        learnList.add(bean);
        bean =new ThymeleafBean("后端编程嘟","Spring Boot教程和视频 ","http://www.toutiao.com/m1559096720023553/");
        learnList.add(bean);
        bean =new ThymeleafBean("程序猿DD","Spring Boot系列","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new ThymeleafBean("纯洁的微笑","Sping Boot系列文章","http://www.ityouknow.com/spring-boot");
        learnList.add(bean);
        bean =new ThymeleafBean("CSDN——小当博客专栏","Sping Boot学习","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new ThymeleafBean("梁桂钊的博客","Spring Boot 揭秘与实战","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new ThymeleafBean("林祥纤博客系列","从零开始学Spring Boot ","http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(bean);
        return learnList;
    }
}
