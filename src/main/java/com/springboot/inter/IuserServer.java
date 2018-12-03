package com.springboot.inter;

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
}
