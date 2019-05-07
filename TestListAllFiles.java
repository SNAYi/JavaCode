import java.io.File;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/7 下午 08:14
 */

public class TestListAllFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\11411\\Desktop\\记录");
        long start = System.currentTimeMillis();
        ListAllFiles(file);
        long end = System.currentTimeMillis();
        System.out.println("When traversing the current file："+(end - start)+"mS");
    }
    public static void ListAllFiles(File file) {
        if (file != null) {
            //1.如果file是文件夹，需要一步步拆分
            if (file.isDirectory()) {
                File[] files = file.listFiles();   //1.1获取到了当前路径所有文件
                for (File result:files) {
                    //1.2当前路径所有文件中还有某些文件是文件夹，继续递归调用
                        ListAllFiles(result);
                }
            } else {
                //2.如果file是文件
                System.out.println(file);
            }
        }
    }
}
