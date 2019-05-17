/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/17 下午 03:56
 */

//将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)
//要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。

//题解：只有当时一串正数或者负数字符串时，才能输出，否则都输出0 例：-2147483647 +2147483647  123 可以输出
//    "    1a33"就不能输出 ""也不能输出
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483647"));
    }
    //str->char->int
    public static int StrToInt(String str) {
        char[] array = str.toCharArray();    //str->char[]
        int len = array.length;
        int symbol = 0;    //代表是个正数字符串,用来在最后输出
        int sum = 0;
        if (len == 0) {    //字符串为空
            return 0;
        }

        if (array[0] == '-') {
            symbol = 1;    //代表是个负数字符串
        }

        for (int i = 0; i < len; i++) {
            if (array[i] == '+' ||array[i] == '-') {
                continue;
            } else if (array[i] <'1' || array[i] > '9') {
                return 0;
            } else {
                sum = sum *10 + (array[i] - 48);
            }
        }
        return  symbol == 0 ? sum :-sum;
    }

}
