package com.springboot.server;

import com.myspringboot.springboottest.SpringboottestApplication;
import com.springboot.entity.LearnBean;
import com.springboot.inter.IlearnServer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringboottestApplication.class})
public class BatisLearnServerTest {
    @Autowired
    private IlearnServer batisLearnServer;

    @Test
    public void add() {
    }

    @Test
    public void deleteByIds() {
    }

    @Test
    public void update() {
    }

    @Test
    public void queryById() {
        int id = 999;
        LearnBean l = batisLearnServer.queryById(id);
        System.out.println(l);
        Assert.assertThat(l.getAuthor(),is("官方SpriongBoot例子"));
    }

    @Test
    public void queryLearnResouceList() {
    }

    @Test
    public void queryByLike() {
    }
}