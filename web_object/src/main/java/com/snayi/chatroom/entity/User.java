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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
