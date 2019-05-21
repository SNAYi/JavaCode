/**
 *
 */

import java.io.*;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/14 下午 09:24
 */


public class TestByteArrayInputStream {
    public static void main(String[] args) throws IOException {
        String string = "hello world";
        InputStream in = new ByteArrayInputStream(string.getBytes());
        OutputStream out = new ByteArrayOutputStream();
        int len = 0;
        while ((len = in.read()) != -1) {
            out.write(Character.toUpperCase(len));
        }
        System.out.println(out);
        in.close();
        out.close();
    }
}
