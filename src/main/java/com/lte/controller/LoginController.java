package com.lte.controller;

import com.lte.common.Result;
import com.lte.pojo.User;
import com.lte.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Auther: laite
 * @Date: 2021/9/18 - 09 - 18 - 13:15
 * @Description: com.lte.controller
 * @version: 1.0
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService LoginService;

    @PostMapping("/login")
    public Result login(@RequestBody User user,String code, HttpServletRequest request) {
        String getCode = (String) request.getServletContext().getAttribute("code");
        System.out.println("接收的code:"+code);
        if (!getCode.equalsIgnoreCase(code)) {
            return new Result("验证码输入错误", false);
        }
        User findUser = LoginService.login(user);
        if (findUser != null) {
            Result result = new Result(findUser, "登录成功", true);
            return result;
        }
        Result result = new Result("账号或密码错误", false);
        return result;

    }

}
