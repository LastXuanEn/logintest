package com.lte.service.impl;

import com.lte.mapper.LoginMapper;
import com.lte.pojo.User;
import com.lte.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: laite
 * @Date: 2021/9/18 - 09 - 18 - 13:44
 * @Description: com.lte.service.impl
 * @version: 1.0
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public User login(User user) {
        User user1 = loginMapper.login(user);
        return user1;
    }

    @Override
    public User get(Integer id) {
        User user = loginMapper.get(id);
        return user;
    }
}
