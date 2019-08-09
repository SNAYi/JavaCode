package com.snayi.chatroom.controller;

import com.snayi.chatroom.config.FreeMarkerListener;
import com.snayi.chatroom.service.AccountService;
import com.snayi.chatroom.utils.CommUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-09 12:10
 * @Description:  用户登录校验
 */
/*@WebServlet("/login")
public class LoginController extends HttpServlet {
    private AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=utf8");
        PrintWriter writer = resp.getWriter();
        if (CommUtils.StrIsEmpty(userName) || CommUtils.StrIsEmpty(password)) {
            // 登录失败，继续尝试登录
            writer.println("    <script>\n" +
                    "        alert(\"用户名或密码为空\");\n" +
                    "        window.location.href = \"/index.html\";\n" +
                    "    </script>");
        }
        if (accountService.userLogin(userName,password)) {
            //登陆成功，跳转到聊天界面
        } else {
            // 登录失败,停留在登录页面
            writer.println("    <script>\n" +
                    "        alert(\"用户名或密码不正确 \");\n" +
                    "        window.location.href = \"/index.html\";\n" +
                    "    </script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}*/
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private AccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=utf8");
        PrintWriter writer = resp.getWriter();
        if (CommUtils.StrIsEmpty(userName) || CommUtils.StrIsEmpty(password)) {
            // 登录失败,停留登录页面
            writer.println("    <script>\n" +
                    "        alert(\"用户名或密码为空!\");\n" +
                    "        window.location.href = \"/index.html\";\n" +
                    "    </script>");
        }
        if (accountService.userLogin(userName,password)) {
            // 登录成功,跳转到聊天页面
            //加载chat.ftl
            Template template = getTemplate(req, "/chat.ftl");
            Map<String,String> map = new HashMap<>();
            map.put("username",userName);
            try {
                //将map传给前端
                template.process(map,writer);
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }else {
            // 登录失败,停留在登录页面
            writer.println("    <script>\n" +
                    "        alert(\"用户名或密码不正确!\");\n" +
                    "        window.location.href = \"/index.html\";\n" +
                    "    </script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private Template getTemplate(HttpServletRequest req, String fileName) {
        Configuration conf = (Configuration) req.getServletContext().getAttribute(FreeMarkerListener.TEMPLATE_KEY);
        try {
            return conf.getTemplate(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

