/**
 *
 */

import java.util.Scanner;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/24 上午 10:41
 */


public class Main{
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        for(int i = 0;i <s.length()&&(left < right);i++) {
            if(s.charAt(left)!= s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();


        int count = 0;

        for(int i = 0;i<=A.length();i++) {
            StringBuilder sb = new StringBuilder(A);
            sb.insert(i,B);
            if(isPalindrome(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}
/*public class Main {
    public static boolean isHuiwen(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int count = 0;
        for (int i = 0; i <= str1.length(); i++) {
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i, str2);
            if (isHuiwen(sb.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }
}*/
