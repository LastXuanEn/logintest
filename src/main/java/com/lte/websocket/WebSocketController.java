package com.lte.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Auther: laite
 * @Date: 2022/6/7 - 06 - 07 - 23:25
 * @Description: com.lte.websocket
 * @version: 1.0
 */

// 目前没啥用
@RestController
public class WebSocketController {

    // @RequestMapping("/websocket")
    public void push(String name,String msg) throws IOException {
        msg = name + "," + msg;
        WebSocketService.sendMessage("laitingen",msg);
    }
}
