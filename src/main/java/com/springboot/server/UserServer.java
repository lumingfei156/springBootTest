package com.springboot.server;

import com.springboot.bean.ConfigBean;
import com.springboot.bean.User;
import com.springboot.inter.IuserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

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

    @Resource(name = "consumerQueueThreadPool")
    private ExecutorService consumerQueueThreadPool;

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

    @Override
    public Map<String, String> login(HttpServletRequest request) {
        Map<String,String> toReturn = new HashMap<>();
        String name = request.getParameter("userName");
        String pass = request.getParameter("password");

        if (!"".equals(name) && !"".equals(pass)){
            User user = new User(name,pass);
            request.getSession().setAttribute("user",user);
            toReturn.put("result","1");
        }else {
            toReturn.put("result","0");
        }
        return toReturn;
    }
}
