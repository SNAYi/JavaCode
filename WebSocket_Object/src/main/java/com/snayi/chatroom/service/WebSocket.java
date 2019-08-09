package com.snayi.chatroom.service;

import com.snayi.chatroom.entity.MessageFromClient;
import com.snayi.chatroom.entity.MessageToClient;
import com.snayi.chatroom.utils.CommUtils;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-09 14:41
 * @Description:
 */
@ServerEndpoint("/websocket")
public class WebSocket {
    //存储所有连接到后端的websocket,用static是为了让websocket共享，否则每个窗口都会有自己的
    private static CopyOnWriteArrayList<WebSocket> clients = new CopyOnWriteArrayList<>();
    //存储所有用户列表
    private static Map<String,String> names = new ConcurrentHashMap<>();
    //绑定相应websocket会话
    private Session session;
    //当前客户端的用户名
    private String userName;

    //建立连接
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        // username=' + '${username}
        String userName = session.getQueryString().split("=")[1];
        this.userName = userName;
        // 将客户端聊天实体保存到clients
        clients.add(this);
        // 将当前用户以及SessionID保存到用户列表
        names.put(session.getId(),userName);
        System.out.println("SessionID为"+session.getId() +"的用户："+userName+
                "上线");
        // 发送给所有在线用户一个上线通知
        MessageToClient message2Client = new MessageToClient();
        message2Client.setContent(userName+"上线了!");
        message2Client.setNames(names);
        // 发送信息
        String jsonStr = CommUtils.obj2Json(message2Client);
        for (WebSocket webSocket : clients) {
            webSocket.sendMessage(jsonStr);
        }
    }
    public void onError(Throwable e) {
        System.err.println("websocket连接失败");
        e.printStackTrace();
    }

    //接收服务器消息，显示到浏览器端
    @OnMessage
    public void onMessage(String message) {
        /*//将msg->MessageFromClient
        MessageFromClient messageFromClient = (MessageFromClient) CommUtils
                .json2Obj(message,MessageFromClient.class);
        //群聊信息
        if (messageFromClient.getType().equals("1")) {
            String content = messageFromClient.getMsg();
            MessageToClient messageToClient = new MessageToClient();
            messageToClient.setContent(content);
            messageToClient.setNames(names);
            for (WebSocket socket:clients) {
                socket.sendMessage(CommUtils.obj2Json(messageToClient));
            }
        } else if (messageFromClient.getType().equals("2")) { //私聊消息
            //私聊内容
            String content = messageFromClient.getMsg();
            int toL = messageFromClient.getTo().length();
            //拿到了需要发消息的sessionId
            String to[] = messageFromClient.getTo().substring(0,toL-1).split("-");
            List<String> list = Arrays.asList(to);
            for (WebSocket webSocket:clients) {
                if (list.contains(webSocket) && webSocket.session.getId()
                        !=this.session.getId()) {
                    //发送私聊信息
                    MessageToClient messageToClient = new MessageToClient();
                    messageToClient.setContent(userName,content);
                    messageToClient.setNames(names);
                    webSocket.sendMessage(message);
                }
            }
        }*/
        // 将msg -> MessageFromClient
        MessageFromClient messageFromClient = (MessageFromClient) CommUtils
                .json2Obj(message,MessageFromClient.class);
        if (messageFromClient.getType().equals("1")) {
            // 群聊信息
            String content = messageFromClient.getMsg();
            MessageToClient message2Client = new MessageToClient();
            message2Client.setContent(content);
            message2Client.setNames(names);
            // 广播发送
            for (WebSocket webSocket : clients) {
                webSocket.sendMessage(CommUtils.obj2Json(message2Client));
            }
        }else if (messageFromClient.getType().equals("2")) {
            // 私聊信息
            // {"to":"0-1-2-","msg":"33333","type":2}
            // 私聊内容
            String content = messageFromClient.getMsg();
            int toL = messageFromClient.getTo().length();
            String tos[] = messageFromClient.getTo()
                    .substring(0,toL-1).split("-");
            List<String> lists = Arrays.asList(tos);
            // 给指定的SessionID发送信息
            for (WebSocket webSocket : clients) {
                if (lists.contains(webSocket.session.getId()) &&
                        this.session.getId() != webSocket.session.getId()) {
                    // 发送私聊信息
                    MessageToClient message2Client = new MessageToClient();
                    message2Client.setContent(userName,content);
                    message2Client.setNames(names);
                    webSocket.sendMessage(CommUtils.obj2Json(message2Client));
                }
            }
        }
    }

    @OnClose
    public void onClose() {
        //将当前客户端聊天实体移除
        clients.remove(this);
        // 将当前用户以及SessionID保存到用户列表
        names.remove(session.getId());
        System.out.println("SessionID为"+session.getId() +"的用户："+userName+
                "下线");
        // 发送给所有在线用户一个下线通知
        MessageToClient message2Client = new MessageToClient();
        message2Client.setContent(userName + "下线了");
        message2Client.setNames(names);
        // 发送信息
        String jsonStr = CommUtils.obj2Json(message2Client);
        for (WebSocket webSocket : clients) {
            webSocket.sendMessage(jsonStr);
        }
    }

    public void sendMessage(String message) {
        try {
            //当前在服务器端，将message消息发送给远程的浏览器端
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
