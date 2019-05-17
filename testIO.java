/**
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/17 下午 07:40
 */


public class testIO {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Test\\HHH.txt");  //1
        //使用PrintStream向文件输出内容
     /*   PrintStream print =new PrintStream(new FileOutputStream(file));    //2
        print.println("姓名：张三");    //3
        print.println("年龄：20");    //3
        print.close();*/
     //使用Scanner从文件读取内容
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {    //如果内容没读完就继续读
            System.out.println(scanner.next());    //输出读到的内容
        }
        scanner.close();    //4

    }
}
