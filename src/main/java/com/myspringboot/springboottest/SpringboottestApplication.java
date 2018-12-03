package com.myspringboot.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lulu
 * @since 2018/12/3
 * springBoot的启动类
 */
@RestController
@SpringBootApplication
public class SpringboottestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottestApplication.class, args);
	}

	/**
	 * 测试是否启动成功
	 * @return hello world springBoot
	 */
	@RequestMapping("/")
	public String index(){
		return "Hello world springBoot";
	}
}
