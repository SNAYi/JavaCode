package com.snayi.chatroom.service;

import com.snayi.chatroom.dao.AccountDao;
import com.snayi.chatroom.entity.User;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-09 11:13
 * @Description:
 */
public class AccountService {
    private AccountDao account = new AccountDao();
    //用户注册
    public boolean userRegister(String userName,String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return account.userRegister(user);
    }
    //用户登录
    public boolean userLogin(String userName,String password) {
        User user = account.userLogin(userName,password);
        if (user == null) {
            return false;
        }
        return true;
    }
}
