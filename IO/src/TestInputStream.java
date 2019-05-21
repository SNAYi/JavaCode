/**
 *
 */

import java.io.*;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/14 下午 07:04
 */


public class TestInputStream {
    public static void main(String[] args) {
        //1.取得终端对象
        File file = new File("D:\\Test\\test.txt");
        //2.取得输入流
        InputStream in = null;

           try {
                in = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //3.读取数据
            int len = 0;
            byte[] data = new byte[1024];    //创建缓冲区
            try {
                len = in.read(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("文件内容为"+new String(data,0,len));
            //4.关闭流
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
