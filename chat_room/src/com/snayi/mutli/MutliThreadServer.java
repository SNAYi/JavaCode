package com.snayi.mutli;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-04 14:12
 * @Description:
 */
public class MutliThreadServer {
    //用一个map存放所有连接的客户端
    private static Map<String, Socket> clientMap = new ConcurrentHashMap<>();

    //转发各个客户端消息的类
    public static class ExecuteClientNews implements Runnable{
        private Socket client;

        public ExecuteClientNews(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            //接收客户端发来的消息
            Scanner in = null;
            try {
                in = new Scanner(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true) {
                if (in.hasNextLine()){
                    String news = in.nextLine();
                    //用户注册 R:用户名
                    if (news.startsWith("R:")) {
                        clientReg(news.split(":")[1],client);    //调用注册流程
                    }
                    //用户群聊 G:
                    if (news.startsWith("G:")) {
                        groupChat("群聊消息为:"+news.split(":")[1]);
                    }
                    //用户私聊 P:私聊对象的用户名-发送消息
                    if(news.startsWith("P:")) {
                        String userName = news.split(":")[1].split("-")[0];
                        privateChat(userName,"私聊信息为："+news.split("-")[1]);
                    }
                    //用户退出
                    if (news.contains("-1")) {
                        exit(client);
                    }
                }
            }
        }
        //注册流程
        private void clientReg(String userName,Socket client) {
            //将客户端注册到当前服务器
            clientMap.put(userName,client);
            System.out.println("当前在线人数："+clientMap.size());
            System.out.println("用户"+userName+"已上线!");
            //通知所有客户端有客户端上线
            groupChat("用户"+userName+"已上线!");
        }
        //群聊流程
        private void groupChat(String news) {
            //获得所有的客户端
            Collection<Socket> clients = clientMap.values();
            //给每一个客户端都发此消息
            for (Socket client:clients) {
                PrintStream out = null;
                try {
                    out = new PrintStream(client.getOutputStream(),
                            true,"utf-8");    //拿到输出流
                    out.println(news);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        //私聊流程
        public  void privateChat(String userName,String news) {
            //通过key值找到value
            Socket client = clientMap.get(userName);
            //拿到输出流
            PrintStream out = null;
            try {
                out = new PrintStream(client.getOutputStream(),
                        true,"utf-8");
                out.println(news);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //退出流程
        private void exit(Socket client) {
            //拿到所有的用户名
            Set<String> userNames = clientMap.keySet();
            for (String userName: userNames) {
                if (clientMap.get(userName).equals(client)){
                    clientMap.remove(userName);
                    //更新在线人数
                    System.out.println("当前在线人数:"+clientMap.size());
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //建立服务器并绑定端口
        ServerSocket serverSocket = new ServerSocket(6666);

        //统一管理线程：创建线程池-设置线程的数目
        ExecutorService service = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 20; i++) {
            System.out.println("等待客户端连接");
            Socket client = serverSocket.accept();
            System.out.println("有新客户端连接，端口号为："+client.getPort());
            //新建一个线程处理客户端的连接
            service.submit(new ExecuteClientNews(client));
        }
        serverSocket.close();

    }
}
