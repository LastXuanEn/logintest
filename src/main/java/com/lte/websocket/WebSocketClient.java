package com.lte.websocket;

import lombok.Data;

import javax.websocket.Session;

/**
 * @Auther: laite
 * @Date: 2022/6/7 - 06 - 07 - 23:35
 * @Description: com.lte.websocket
 * @version: 1.0
 */
@Data
public class WebSocketClient {
    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //连接的uri
    private String uri;

}
