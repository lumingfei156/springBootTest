package com.springboot.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author lulu
 * springBoot使用线程池
 */
@Configuration
public class ThreadPoolUtil {

    public ThreadPoolUtil(){

    }

    /**
     * 获取线程池方法
     * @return x
     */
    @Bean(value="consumerQueueThreadPool")
    public ExecutorService getThreadPool(){
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("consumer-queue-thread-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
        return pool ;


    }


}
