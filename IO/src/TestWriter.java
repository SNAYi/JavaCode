/**
 *
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/15 下午 03:03
 */


public class TestWriter {
    public static void main(String[] args) throws Exception {
        //1.取得终端对象
        File file = new File("C:"+File.separator+"Test"+File.separator+"hello.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        String string = "test Writer";
        Writer out = new FileWriter(file);    //2.取得输出流
        out.write(string);    //3.输出
        //out.close();    //4.关闭流
        out.flush();    //必须有关闭流操作或者刷新
    }
}
