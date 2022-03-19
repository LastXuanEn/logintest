package com.lte.controller;

import com.github.pagehelper.Page;
import com.lte.mapper.PurchaseStorageMapper;
import com.lte.pojo.User;
import com.lte.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

/**
 * @Auther: laite
 * @Date: 2022/3/4 - 03 - 04 - 21:41
 * @Description: com.lte.controller
 * @version: 1.0
 */
@RestController
public class AsyncController {
    @Autowired
    LoginService loginService;

    @Autowired
    PurchaseStorageMapper purchaseStorageMapper;

    @Autowired
    ThreadPoolExecutor threadPoolExecutor;


    @RequestMapping("/callable")
    public Callable<Object> getUserInfoAsync(@RequestParam("id") int userId){
        //开辟一个子线程
        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                User user = loginService.get(userId);
                System.out.println(Thread.currentThread().getName()+ "：子线程结束，获取user："+user);
                return user;
            }
        };
        System.out.println(Thread.currentThread().getName()+":tomcat线程结束");
        return callable;

    }

    @RequestMapping("/futureTask")
    public Object getPucharseStorage() throws InterruptedException, ExecutionException, TimeoutException {
        //开辟一个子线程
        Callable<Object> callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Page page = purchaseStorageMapper.findPage("");
                return page;
            }
        };
        FutureTask<Object> futureTask = new FutureTask<>(callable);
        threadPoolExecutor.execute(futureTask);
        return futureTask.get(3, TimeUnit.SECONDS);
    }
}
