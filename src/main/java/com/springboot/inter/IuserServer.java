package com.springboot.inter;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author lulu
 * @since 2018/12/03
 * 在controller中使用配置文件属性
 */
public interface IuserServer {

    /**
     * 在接口文件中使用application.properties中的属性
     * @return ss
     */
    String useConfig();

    /**
     * 通过bean来引用配置文件中的属性
     * @return ss
     */
    String useConfigByBean();

    /**
     * 用户登陆操作
     * @param request ss
     * @return ss
     */
    Map<String,String> login(HttpServletRequest request);
}
