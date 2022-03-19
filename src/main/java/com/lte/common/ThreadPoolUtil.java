package com.lte.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: laite
 * @Date: 2022/3/5 - 03 - 05 - 20:34
 * @Description: com.lte.config
 * @version: 1.0
 */
@Configuration
public class ThreadPoolUtil {
    @Bean
    public BlockingQueue getBlockingQueue(){
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(3,Integer::compare);
        return queue;
    }
    @Bean
    public ThreadPoolExecutor getThreadPool(){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, getBlockingQueue());
        return threadPool;
    }
}
