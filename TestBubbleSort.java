package com.bit.dao;

import java.util.Arrays;


public class TestBubbleSort {
    public static void bubbleSort(int[] array){
        //用count来看array是否有序.如果有序，在一趟排序之后，count不变，直接跳出
        int count =0;
        //趟数 例：5个数，排0~3趟
        for (int i = 0; i <array.length - 1; i++) {
            //每一趟排几次
            for (int j = 0; j <array.length - 1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] =temp;
                    count++;
                }
            }
            if(count ==0) {
                System.out.println("count="+ count);
                break;
            }

        }

    }

    public static void main(String[] args) {
        int[] array = {12,3,5,9,1};
        System.out.println("未排序前" + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("排序后：" + Arrays.toString(array));

    }
}
