package com.springboot.server;

import com.myspringboot.springboottest.SpringboottestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringboottestApplication.class})
public class BatisUserServerTest {

    @Test
    public void queryById() {

    }
}