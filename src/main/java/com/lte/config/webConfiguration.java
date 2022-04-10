package com.lte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.web.filter.CorsFilter;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @Auther: laite
 * @Date: 2022/4/9 - 04 - 09 - 17:38
 * @Description: com.lte.config
 * @version: 1.0
 */
@Configuration
public class webConfiguration implements WebMvcConfigurer {

    @Bean // 添加过滤器
    public CorsFilter CorsFilter() {
        // 基于url跨域，选择reactive包下的
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 跨域配置信息
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许跨域的头
        corsConfiguration.addAllowedHeader("*");
        // 允许跨域的请求方式
        corsConfiguration.addAllowedMethod("*");
        // 允许跨域的请求来源
        corsConfiguration.addAllowedOrigin("*");
        // 是否允许携带cookie跨域
        corsConfiguration.setAllowCredentials(true);

        // 任意url都要进行跨域配置
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

}
