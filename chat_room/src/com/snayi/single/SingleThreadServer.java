package com.snayi.single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) throws Exception {
        //1.建立服务器端并绑定端口(绑定后就是该服务器的端口)
        ServerSocket serverSocket = new ServerSocket(8888);

        //2.等待客户端连接
        System.out.println("等待客户端连接");
        Socket client = serverSocket.accept();
        System.out.println("客户端连接成功,端口号为"+client.getPort());

        //接收客户端发来的消息
        Scanner in = new Scanner(client.getInputStream());
        if (in.hasNextLine()) {
            String clientNews = in.nextLine();
            System.out.println("客户端发来的消息为："+clientNews);
        }

        //向客户端发送消息
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("i am server");

        //关闭流
        in.close();
        out.close();
        client.close();
    }
}
