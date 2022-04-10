package com.lte.controller;

import com.lte.common.QiNiuUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Auther: laite
 * @Date: 2022/4/4 - 04 - 04 - 14:49
 * @Description: com.lte.controller
 * @version: 1.0
 */
@RestController
public class QiNiuController {
    @RequestMapping("/qiniu")
    public String qiniu() throws IOException {
        File file = new File("src\\main\\resources\\public\\111B.png");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int len = 0;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        byte[] fileByte = outputStream.toByteArray();
        QiNiuUtil.upload2Qiniu(fileByte,"123.png");
        fileInputStream.close();
        outputStream.close();
        return "ok";
    }
}
