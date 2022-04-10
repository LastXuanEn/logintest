package com.lte.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: laite
 * @Date: 2022/3/19 - 03 - 19 - 16:19
 * @Description: com.lte.config
 * @version: 1.0
 */
@Data
// @ConfigurationProperties("people")
public class PeopleProperties implements Serializable {

    private static final long serialVersionUID = -5711650523706073408L;
    private Integer age;
    private String name;


}
