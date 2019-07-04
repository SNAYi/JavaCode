package com.snayi.mutli;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 */
public class MutliThreadClient {

    //向服务器端发送消息
    private static class WriteToServer implements  Runnable{
        private Socket client;

        public WriteToServer(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            //从键盘输入消息
            Scanner in = new Scanner(System.in);
            //拿到输出流，设置为缓存区一直刷新，直接输出到服务器端，编码格式为utf-8
            PrintStream out = null;
            try {
                out = new PrintStream(client.getOutputStream(),true,"utf-8");   //
            } catch (IOException e) {
                e.printStackTrace();
            }
            //向服务器端输出
            while (true) {
                System.out.println("请输入信息：");
                if (in.hasNextLine()) {
                    String scannerNews = in.nextLine();
                    out.println(scannerNews);
                    //如果键盘发出输出指令-1 (表示不聊了)，就退出
                    if (scannerNews.contains("-1")) {
                        System.out.println("客户端退出");
                        break;
                    }
                }
            }
            in.close();
            out.close();
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //从服务器端读取信息
    private static class ReadFromServer implements Runnable{
        private Socket client;    //保证读取的是同一个客户端

        public ReadFromServer(Socket client) throws Exception {
            this.client = client;
        }

        @Override
        public void run() {
            //拿到输入流
            Scanner in = null;
            try {
                in = new Scanner(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            //保持一直输出 拿到的消息
            while(true) {
                //如果客户端已关闭，则退出输出
                if (client.isClosed()) {
                    System.out.println("客户端已关闭");
                    break;
                }
                //一直输出
                if(in.hasNextLine()) {
                    // String serverNews =
                    System.out.println("服务器端发来的消息为："+in.nextLine());
                }
            }
            //关闭输入流
            in.close();
        }
    }
    public static void main(String[] args) throws Exception {
        //与服务器端建立联系
        Socket client = new Socket("127.0.0.1",6666);
        //创建读写线程
        Thread writeThread = new Thread(new WriteToServer(client));
        Thread readThread = new Thread(new ReadFromServer(client));
        writeThread.start();
        readThread.start();
    }
}
