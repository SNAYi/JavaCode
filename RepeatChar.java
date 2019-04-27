/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/4/27 下午 06:52
 */

/**
 *  给定一个英文字符串，写一段代码找出字符串中首先出现三次的英文字母。 输入描述：输入数据一个
 * 字符串，包括字母，数字 输出描述：输出首先出现三次的那个英文字符 示例： 输入： Have you ever gone shopping and
 * 输出:e
 */
public class RepeatChar {
    public static void main(String[] args) {
        String str = "Have you ever gone shopping and";
        System.out.println(searchTheLetterAppearThreeTimes(str));
        System.out.println(searchTheLetterAppearThreeTimes("11111112"));
        System.out.println(searchTheLetterAppearThreeTimes(""));
        System.out.println(searchTheLetterAppearThreeTimes(null));
    }

    /**
     *
     * @param str: The string to be checked
     * @return Returns the first English letter to appear three times.
     */
    public static char searchTheLetterAppearThreeTimes(String str){
        //1.校验字符串合法性
        if (str == null ||str.length() == 0) {
            throw new NullPointerException("The string cannot be empty or null");
        }
        //2.将String ->char[]
        char[] c = str.toCharArray();
        //3.用来计算字母出现的次数
        int[] counter = new int[128];
        for (int i = 0; i < c.length; i++) {
            char temp = c[i];
            //4.判断temp是否是字母
            if ('A' <= temp && temp <= 'Z' || 'a' <= temp && temp <= 'z') {
                counter[temp]++;    //char类型的可以直接给int类型，会变成char的相应ASCII码
            }
            if (counter[temp] == 3){
                return temp;
            }
        }
        throw new RuntimeException("can't find a letter that appears three times");
    }
}
