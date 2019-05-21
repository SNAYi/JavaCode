/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/7 下午 10:14
 */

import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  1.根据文件路径创建File类对象 ；
 *  2. 根据字节流或字符流的子类实例化父类对象 ；
 *  3.取得相应终端的输出流，将数据通过输出流输出/输入流输入
 *  4.关闭流
 */
public class TestOutputStream {
    public static void main(String[] args) throws IOException {
        //1.全部内容输出
        File file = new File("D:\\Test\\test.txt");    //1.
        if (!file.getParentFile().exists()) { //必须确定file的父目录存在，如果不在则创建 //2.
            file.getParentFile().mkdirs();
        }
        //3.1拿到要输出的文件 这里不加append，是会覆盖
        OutputStream output = new FileOutputStream(file,true) ;
        String msg = "hello world";
        output.write(msg.getBytes());    //3.2 给文件里输出内容
        output.close();    //4

        //2.部分内容输出
        File file2 = new File("D:\\Test\\test2.txt");    //1.
        if (!file2.getParentFile().exists()) { //必须确定file的父目录存在，如果不在则创建 //2.
            file2.getParentFile().mkdirs();
        }
        //3.1拿到要输出的文件 这里不加append，是会覆盖
        OutputStream output2 = new FileOutputStream(file2,true) ;
        String msg2 = "hello world";
        output2.write(msg2.getBytes(),4,7);    //3.2 给文件里输出内容,从第四个字符开始输出

        //3.输出单个字节
        output2.write(97); //输出的是a
        output2.close();    //4
    }

}
