package com.lte.mapper;

import com.lte.pojo.User;

/**
 * @Auther: laite
 * @Date: 2021/9/18 - 09 - 18 - 13:51
 * @Description: com.lte.mapper
 * @version: 1.0
 */
public interface LoginMapper {
    User login(User user);

    User get(Integer id);
}
