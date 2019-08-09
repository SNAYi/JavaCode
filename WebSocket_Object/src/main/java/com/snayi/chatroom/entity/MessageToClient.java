package com.snayi.chatroom.entity;

import lombok.Data;

import java.util.Map;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-09 18:10
 * @Description: 后端发送给前端的信息
 */
@Data
public class MessageToClient {
    //聊天内容
    private String content;
    //服务端登录的所有用户列表
    private Map<String,String> names;

    public void setContent(String content) {
        this.content = content;
    }
    public void setContent(String userName,String content) {
        this.content = userName+"说：" +content;
    }
}
