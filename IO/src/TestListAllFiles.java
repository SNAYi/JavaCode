import java.io.File;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/7 下午 08:14
 */

public class TestListAllFiles {
    public static void main(String[] args) {
        File file = new File("C:"+File.separator+"Users"+File.separator+"11411"+
                File.separator+"Desktop"+File.separator+"资料");
        long start = System.currentTimeMillis();
        ListAllFiles(file);
        long end = System.currentTimeMillis();
        System.out.println("When traversing the current file："+(end - start)+"mS");
    }

    /**<p>Enumerates all files in the specified path
     * @auther SNAYi
     * Recursive implementation
     */
    public static void ListAllFiles(File file){
        //1.确定是个目录
        if (file.exists() && file.isDirectory()) {
            //2.取出目录中所有文件的名称
            File[] files =file.listFiles();
            for (File temp:files) {
                //判断每一个文件是不是还是目录，如果是则继续递归，不是则输出文件名
                ListAllFiles(temp);
            }
        } else {
            System.out.println(file);
        }
    }

//    public static void ListAllFiles(File file) {
//        if (file != null) {
//            //1.如果file是文件夹，需要一步步拆分
//            if (file.isDirectory()) {
//                File[] files = file.listFiles();   //1.1获取到了当前路径所有文件
//                for (File result:files) {
//                    //1.2当前路径所有文件中还有某些文件是文件夹，继续递归调用
//                        ListAllFiles(result);
//                }
//            } else {
//                //2.如果file是文件
//                System.out.println(file);
//            }
//        }
//    }
}
