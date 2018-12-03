package com.springboot.server;

import com.springboot.bean.ConfigBean;
import com.springboot.inter.IuserServer;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ConfigBean configBean;

    /**
     * 在接口文件中使用application.properties中的属性
     * @return string
     */
    @Override
    public String useConfig() {
        return "mysqlName: " + this.mysqlName + "\n" + "mysqlPass:" + mysqlPass;
    }

    /**
     * 通过bean来引用配置文件中的属性
     *
     * @return ss
     */
    @Override
    public String useConfigByBean() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: " + configBean.getName() + "\n sex :" + configBean.getSex()) ;
        sb.append("\nconcat: " + configBean.getConcat());
        sb.append("\nsrecte: " + configBean.getSrecte());
        sb.append("\nnumber: " + configBean.getNumber());
        return sb.toString();
    }


}
