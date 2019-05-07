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
 * 1.取得终端对象
 * 2.取得相应终端的输出流
 * 3.将数据通过输出流输出
 * 4.关闭流
 */
public class TestOutputStream {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\11411\\Desktop\\test.txt");    //1.
        if (!file.getParentFile().exists()) { //必须确定中断对象的父目录存在，如果不在则创建
            file.getParentFile().createNewFile();
        }
        OutputStream output = new FileOutputStream(file,true) ;    //2 这里不加append，是会覆盖
        String msg = "hello world\n";
        output.write(msg.getBytes());    //3
        output.close();    //4
    }

}
