package com.lte.config.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: laite
 * @Date: 2022/3/19 - 03 - 19 - 22:22
 * @Description: com.lte.config.filter
 * @version: 1.0
 */
@Configuration
public class FilterConfig {
    @Autowired
    MyFilter filter;
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter);
        //以 / 字符开头、以 /*后缀结尾的字符串用于路径映射
        //servlet路径是请求URI减去上下文路径
        registrationBean.addUrlPatterns("/getPeople/*");
        return registrationBean;
    }
}
