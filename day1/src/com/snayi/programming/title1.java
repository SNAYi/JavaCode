package com.snayi.programming;/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/24 上午 10:53
 */


import java.util.*;

public class title1{
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right){
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