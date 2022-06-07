package com.lte.controller;

import com.lte.common.VerifyCodeUtils;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Auther: laite
 * @Date: 2021/9/22 - 09 - 22 - 22:10
 * @Description: com.lte.controller
 * @version: 1.0
 */
@RestController
public class CodeImgController {
    @RequestMapping("/getCodeImg")
    public String getCodeImg(HttpServletRequest request) throws IOException {
//        1、使用工具类生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
//        2、将验证码放入Session作用域
//         request.getServletContext().setAttribute("code",code);
//         String code1 = (String) request.getServletContext().getAttribute("code");
        HttpSession session = request.getSession();
        String id = session.getId();
        session.setAttribute("code",code);
        System.out.println("code = " + code);
//        3、将图片转换为Base64
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(120,30,byteArrayOutputStream,code);
        String string = Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
//        前端img标签显示：base64的编码格式
        return "data:image/png;base64," + string;


    }
}
