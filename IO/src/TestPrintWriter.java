import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/19 下午 03:50
 */


public class TestPrintWriter {
    public static void main(String[] args) throws Exception {
        //2.取得打印流                             1.取得终端对象
        PrintWriter printWriter =
                new PrintWriter(new File("D:"+File.separator+"Test"+File.separator+"PrintWriter.txt"));
        printWriter.print("姓名:");    //3.输出到终端
        printWriter.println("张三");
        printWriter.print("年龄:");
        printWriter.println(21);
        printWriter.print("性别(女为false,男为true)：");
        printWriter.println(true);
        printWriter.close();    //4.务必关闭流
    }
}
