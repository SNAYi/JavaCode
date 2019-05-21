import java.io.*;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/14 下午 07:26
 */


public class CopyFile {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("参数类型非法");
        } else {
            //1.取得终端对象
            File sourceFile = new File(args[0]);
            File descFile = new File(args[1]);
            //2. 取得输入输出流
            InputStream in = new FileInputStream(sourceFile);
            OutputStream out = new FileOutputStream(descFile);
            //3.文件拷贝
            copy(in,out);
        }
    }

    public static void copy(InputStream in,OutputStream out) throws IOException {
        System.out.println("文件开始拷贝");
        long start = System.currentTimeMillis();
        int len = 0;
        byte[] data = new byte[2048];
        while ((len = in.read(data)) != -1) {
            out.write(data,0,len);
        }
        out.close();
        long end = System.currentTimeMillis();
        System.out.println("文件拷贝完成，耗时"+(end - start) +"mS");
    }
}
