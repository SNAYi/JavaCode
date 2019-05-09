import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/8 下午 10:30
 */


public class TestFile {
    public static void main(String[] args) {
        //1.直接实例化对象
        //考虑跨平台问题，将分割符换成File的separator常量
        //File file = new File("C:\\Users\\11411\\Desktop\\TestIO\\test.txt");
        //1.1实例化方式1
        File file = new File("C:"+File.separator+"Users"+File.separator+"11411"
                +File.separator+"Desktop"+File.separator+ "TestIO"+File.separator+"test.txt");
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //1.2实例化方式2
        File file2 = new File("C:"+File.separator+"Users"+File.separator+"11411"
                +File.separator+"Desktop"+File.separator+ "TestIO",File.separator+"test2.txt");
        if (file2.exists()) {
            file2.delete();
        } else {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("===========");
        //2.目录操作
        //2.1取得父路径,返回值类型是String
        System.out.println("Parent:"+file.getParent());
        //2.2取得父File对象，返回值类型是File
        File file3 = new File("C:"+File.separator+"Users"+File.separator+"11411"
                +File.separator+"Desktop"+File.separator+ "TestIO2",File.separator+"test.txt");
        File fileParent = file3.getParentFile();
        //如果父目录不存在，先创建父目录
        if (!fileParent.exists()) {
            fileParent.mkdirs();    //mkdirs()一次创建多级目录
        }
        //创建完父目录后创建文件
        if (file3.exists()) {
            //文件存在，则删除
            file3.delete();
        } else {
            try {
                //不存在则创建文件
                file3.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //3.文件信息
        //这里是有file来举例
        File file4 = new File("C:"+File.separator+"Users"+File.separator+"11411"
                +File.separator+"Desktop"+File.separator+ "TestIO"+File.separator+"yyqx.jpg");

        if (file4.exists() && file4.isFile()) {
            System.out.println("length："+(double)(file4.length()/(1000*1000))+"Mb");
            System.out.println("modified："+new Date(file4.lastModified()));
        }
    }
}
