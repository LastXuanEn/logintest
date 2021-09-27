package com.lte.service;

import com.lte.pojo.User;

/**
 * @Auther: laite
 * @Date: 2021/9/18 - 09 - 18 - 13:43
 * @Description: com.lte.service
 * @version: 1.0
 */
public interface LoginService {
    User login(User user);

    User get(Integer id);
}
