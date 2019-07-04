package com.snayi.single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadClient {
    public static void main(String[] args) throws IOException {
        //1.与服务器连接
        Socket client = new Socket("127.0.0.1",8888);
        System.out.println("与服务器连接成功");

        //客户端拿到连接向服务器发送消息(输出流)
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("i am client");

        //客户端拿到连接从服务器端接收消息
        Scanner in = new Scanner(client.getInputStream());
        if (in.hasNextLine()) {
            String serverNews = in.nextLine();
            System.out.println("服务器端发来的消息为:"+serverNews);
        }

        //关闭流
        out.close();
        in.close();
        client.close();
    }
}
