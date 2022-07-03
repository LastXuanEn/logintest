package com.lte.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lte.common.Result;
import com.lte.mapper.UserMapper;
import com.lte.pojo.User;
import com.lte.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Auther: laite
 * @Date: 2021/9/18 - 09 - 18 - 13:15
 * @Description: com.lte.controller
 * @version: 1.0
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public Result login(@RequestBody User user,String code, HttpServletRequest request) {
        // String getCode = (String) request.getServletContext().getAttribute("code");
        HttpSession session = request.getSession();
        String getCode = (String)session.getAttribute("code");

        log.info("code:{}",code);
        log.info("获取验证码的sessionId:{}",request.getSession().getId());
        if(getCode == null){
            return new Result("请重新刷新页面", false);
        }
        if (!code.equalsIgnoreCase(getCode)) {
            return new Result("验证码输入错误", false);
        }

        User findUser = loginService.login(user);
        log.info("findUser:{}",findUser);
        if (findUser != null) {
            Result result = new Result(findUser, "登录成功", true);
            request.getSession().setAttribute("user",findUser);
            return result;
        }
        return new Result("账号或密码错误", false);

    }
    @RequestMapping("/registry")
    public Result login(@RequestBody @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            StringBuilder message = new StringBuilder();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (int i = 0; i < allErrors.size(); i++) {
                if(i==allErrors.size()-1){
                    message.append(allErrors.get(i).getDefaultMessage());
                }else {
                    message.append(allErrors.get(i).getDefaultMessage()).append(",");
                }
            }
            return new Result(message.toString(), false);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = queryWrapper.eq("username", user.getUsername());
        List<User> users = userMapper.selectList(wrapper);
        if(!users.isEmpty()){
            return new Result("用户名已经存在", false);
        }
        userMapper.insert(user);
        return new Result("注册成功", true);
    }

}
