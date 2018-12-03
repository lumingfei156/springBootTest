package com.springboot.server;

import com.springboot.inter.IuserServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lulu
 * @since 2018/12/03
 * 在控制器中使用配置文件的属性
 */
@Component("userServer")
public class UserServer implements IuserServer{
    @Value("${mysqlName}")
    private String mysqlName;
    @Value("${mysqlPass}")
    private String mysqlPass;

    /**
     * 在接口文件中使用application.properties中的属性
     * @return string
     */
    @Override
    public String useConfig() {
        return "mysqlName: " + this.mysqlName + "\n" + "mysqlPass:" + mysqlPass;
    }
}
