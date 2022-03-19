package com.lte.config;

import com.lte.pojo.People;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: laite
 * @Date: 2022/3/19 - 03 - 19 - 18:33
 * @Description: com.lte.config
 * @version: 1.0
 */
@Configuration
public class PeopleConfiguraton {

    @Bean
    @ConfigurationProperties("people")
    public People getPeople(){
        return new People();
    }
}
