/**
 * @Author: snayi
 * @CreateTime: 2019-07-07 23:25
 * @Description: 生成6位随机字符串 范围为：97~122之间的int型整数->a~z
 */
public class RandomStr {
    public static void main(String[] args) {
        StringBuffer result = new StringBuffer("");
        for (int i = 0; i < 6; i++) {
//            生成范围在97~122间的数
            int temp = (int)(Math.random()*26+97);
            result.append((char)temp);
        }
        System.out.println(result);
    }
}
