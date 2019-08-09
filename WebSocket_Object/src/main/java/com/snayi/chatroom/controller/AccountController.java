package com.snayi.chatroom.controller;

import com.snayi.chatroom.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-09 11:21
 * @Description:  用户注册
 */
@WebServlet("/doRegister")
public class AccountController extends HttpServlet {
    private AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        //向页面输出内容
        //设置html格式和字符集，确保页面不会乱码
        resp.setContentType("text/html;charset=utf8");
        PrintWriter writer = resp.getWriter();
        if (accountService.userRegister(userName,password)) {
            //用户注册成功，先弹框提示注册成功,后返回登录页面
            writer.println("<script>\n" +
                    "    alert(\"注册成功,请登录\");\n" +
                    "    window.location.href = \"/index.html\";\n" +
                    "</script>");
        }else {
            //用户注册失败，先弹框提示失败，后停留在注册页面
            writer.println("<script>\n" +
                    "    alert(\"注册失败,请重新注册\");\n" +
                    "    window.location.href = \"/registration.html\";\n" +
                    "</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}


