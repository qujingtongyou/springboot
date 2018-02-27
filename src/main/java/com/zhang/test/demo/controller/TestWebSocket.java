package com.zhang.test.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 15939 on 2018/2/27.
 *
 * 功能说明：websocket处理类, 使用J2EE7的标准
 * @author Administrator
 * @create 2016-8-11 下午4:08:35
 * @version 1.0
 */
@ServerEndpoint("/websocket/{myWebsocket}")
public class TestWebSocket {

    private static final Logger logger = LoggerFactory.getLogger(TestWebSocket.class);
    public static Map<String, TestWebSocket> clients = new ConcurrentHashMap<>();
    private String userId;
    private String nickname;
    private Session session;
    public TestWebSocket() {
    }
    /**
     * 打开连接时触发
     * @param myWebsocket
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("myWebsocket") String myWebsocket, Session session,EndpointConfig config){
        logger.info("Websocket Start Connecting:" + myWebsocket);
        //获取HttpSession对象
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        String uid = myWebsocket;
        this.userId = uid;
        this.session = session;
        System.out.println("进入："+myWebsocket);
         /*判断链接是否已经在链接队列中，存在就不加*/
        if(!clients.containsKey(uid)){
            clients.put(uid, this);
            String message = "* 你已经链接";
            toConfirmFriend(message,userId);
        }
    }

    /**
     * 收到客户端消息时触发
     * @param message
     * @return
     */
    @OnMessage
    public String onMessage(String message) {
        String[] all = message.split("-");
        //要接收消息好友的ID
        String uid = all[0];
        System.out.print(message);
        System.out.print(uid);
        toConfirmFriend(message,uid);
        return "Got your message ("+ message +").Thanks !";
    }

    /**
     * 异常时触发
     * @param myWebsocket
     * @param throwable
     */
    @OnError
    public void onError(@PathParam("myWebsocket") String myWebsocket, Throwable throwable) {
        logger.info("Websocket Connection Exception:" + myWebsocket);
        logger.info(throwable.getMessage(), throwable);
        clients.remove(myWebsocket);
    }

    /**
     * 关闭连接时触发
     * @param myWebsocket
     */
    @OnClose
    public void onClose(@PathParam("myWebsocket") String myWebsocket) {
        logger.info("Websocket Close Connection:" + myWebsocket);
        clients.remove(myWebsocket);
    }

    /**
     * 将数据传回客户端
     * 异步的方式
     */
    /*public static void broadcast(String myWebsocket, String message) {
        if (clients.containsKey(myWebsocket)) {
            clients.get(myWebsocket).getAsyncRemote().sendText(message);
        } else {
            throw new NullPointerException("[" + myWebsocket +"]Connection does not exist");
        }
    }*/

    //发送给指定的好友
    private static void toConfirmFriend(String msg,String uid) {
        TestWebSocket client = clients.get(uid);
        try {
            synchronized (client) {
                client.session.getBasicRemote().sendText(msg);
            }
        } catch (IOException e) {
            try {
                client.session.close();
            } catch (IOException e1) {
                // Ignore
            }
        }
    }
}
