import java.io.File;
import java.io.IOException;

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
    }
}
