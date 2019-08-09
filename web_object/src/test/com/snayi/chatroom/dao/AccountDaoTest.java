package com.snayi.chatroom.dao;

import com.snayi.chatroom.entity.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-09 10:07
 * @Description:
 */
public class AccountDaoTest {
    private AccountDao account = new AccountDao();
    @Test
    public void userRegister() {
        User user = new User();
        user.setUserName("test");
        user.setPassword("123");
        boolean isSuccess = account.userRegister(user);
        Assert.assertEquals(true,isSuccess);
    }

    @Test
    public void userLogin() {
        User user = account.userLogin("test","123");
        System.out.println(user);
        Assert.assertNotNull(user);
    }
}