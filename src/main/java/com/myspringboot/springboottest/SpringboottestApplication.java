package com.myspringboot.springboottest;

import com.springboot.bean.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lulu
 * @since 2018/12/3
 * springBoot的启动类
 */
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
@ComponentScan("com.springboot.*")
public class SpringboottestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottestApplication.class, args);
	}
	
}
