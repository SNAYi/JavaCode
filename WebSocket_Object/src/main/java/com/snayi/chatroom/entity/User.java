package com.snayi.chatroom.entity;

import lombok.Data;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-01 10:13
 * @Description:
 */
@Data
public class User {
    private Integer id;
    private String  userName;
    private String  password;
}
