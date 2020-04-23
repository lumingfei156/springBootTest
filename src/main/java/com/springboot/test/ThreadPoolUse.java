package com.springboot.test;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

public class ThreadPoolUse {

    @Resource(name = "consumerQueueThreadPool")
    private ExecutorService consumerQueueThreadPool;



    public void useThreadPool() {
        //消费队列
        for (int i = 0; i < 5; i++) {
            consumerQueueThreadPool.execute(()->{
                System.out.println("fuck");
            });
        }
    }


    public static void main(String[] args) {
        Integer o = 1;
        System.out.println(o.getClass().getSimpleName());
    }
}
