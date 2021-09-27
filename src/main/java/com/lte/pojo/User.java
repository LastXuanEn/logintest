package com.lte.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: laite
 * @Date: 2021/9/18 - 09 - 18 - 13:17
 * @Description: com.lte.pojo
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String realname;

}
