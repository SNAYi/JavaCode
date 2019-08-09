package com.snayi.chatroom.entity;

import lombok.Data;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-09 18:07
 * @Description:  前端发送给后端的信息实体类
 */
@Data
public class MessageFromClient {
    //具体聊天信息
    private String msg;
    //聊天类别 1表示群聊  2表示私聊
    private String type;
    //私聊的sessionId
    private String to;

}
