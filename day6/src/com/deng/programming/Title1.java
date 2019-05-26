package com.deng.programming;

import java.util.*;

public class Title1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float A,B,C;
        int y1=0,y2=0,y3=0,y4=0;
        while(sc.hasNextInt()) {
            y1 = sc.nextInt();
            y2 = sc.nextInt();
            y3 = sc.nextInt();
            y4 = sc.nextInt();
        }

        A =(y1 + y3) / 2F;
        B =(y2 + y4) / 2F;
        C =(y4 - y2) / 2F;

        if(A !=(y1 + y3)/2) {
            System.out.println("No");
            return;
        }
        if(B !=(y2 + y4) / 2 || B !=(y3 - y1) / 2  ) {
            System.out.println("No");
            return;
        }
        if(C != (y4 - y2) / 2) {
            System.out.println("No");
            return;
        }
        System.out.println((int)A+" " + (int)B+" " + (int)C);
    }
}