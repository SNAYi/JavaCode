import java.util.*;

/**
 * ip地址和long的相互转换
 */
public class ChangeIP{
    /*ip->long：
     *1.将ip地址按字符串读入，用分隔符分割开后成为一个字符串数组{xyzo}。
     * 2.将数组里的字符串强转为long类型后执行：x^24+y^16+z^8+o  得到最后的返回值。
     * @param strIp :ip地址 例：x.y.z.o
     * @return  转换后的long类型值
     */
  public static long ipToLong(String strIp) {
      String[] s = strIp.split("\\.");
      long ip = (Long.parseLong(s[0]) << 24)
              + (Long.parseLong(s[1]) << 16) +
              (Long.parseLong(s[2]) << 8)
              + (Long.parseLong(s[3]));
      return ip;
  }

    /**
     * long->ip
     * 1.
     * @param longIp
     * @return
     */
    public static String longToIP(long longIp) {
        //采用SB方便追加分隔符 "."
        StringBuffer sb = new StringBuffer("");
        sb.append(String.valueOf(longIp>>24)).append(".").
                append(String.valueOf((longIp&0x00ffffff)>>16)).append(".").
                append(String.valueOf((longIp&0x0000ffff)>>8)).append(".").
                append(String.valueOf(longIp&0x000000ff));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long ip = sc.nextLong();
        System.out.println(ipToLong(s));
        System.out.println(longToIP(ip));
    }
}
