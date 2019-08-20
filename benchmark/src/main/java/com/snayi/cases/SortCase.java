package com.snayi.cases;

import com.snayi.Case;
import com.snayi.annotations.Benchmark;
import com.snayi.annotations.Measurement;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-19 18:21
 * @Description:
 */

/**
 * 1.测试快排与归并的差别
 * 2.自己实现的归并排序与Arrays.sort()对比   用的什么排序算法？  int型用的快排 Onject类用的归并排序
 */
@Measurement(iterators = 10000,group = 3)
public class SortCase implements Case {
    private void quickSort(int[] a) {
        quickSortInternal(a,0,a.length-1);
    }
    //待排序区间是[low,high]
    private void quickSortInternal(int[] a,int low,int high) {
        if (high <= low) {
            return;
        }
        //基准值最终所在的下标
        int[] pivotIndex = partition(a,low,high);
        quickSortInternal(a,low,pivotIndex[0]);
        quickSortInternal(a,pivotIndex[1],high);
    }

    private void swap(int[]a,int x,int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    private int[] partition(int[] a, int low, int high) {
        int pivot = a[high];
        int less = low;
        int i = low;
        int more = high;

        while (i < more) {
            if (a[i] == pivot) {
                i++;
            } else if (a[i] <pivot) {
                swap(a,i,less);
                i++;
                less++;
            } else {
                while (more > i &&a[more] > pivot) {
                    more--;
                }
                swap(a,i,more);
            }
        }
        return new int[]{less-1,more};
    }

    private void mergeSort(int[] a) {
        mergeSostInternal(a,0,a.length);
    }
    //待排序区间是[low，high）
    private void mergeSostInternal(int[] a,int low,int high) {
        if (high <= low+1) {    //只剩一个数
            return;
        }
        int mid = (high+low)>>1;
        //分治
        mergeSostInternal(a,low,mid);
        mergeSostInternal(a,mid,high);
        //合并
        merge(a,low,mid,high);
    }

    private void merge(int[] a, int low, int mid, int high) {
        int length = high -low;
        int[] temp = new int[length];
        int i = low;
        int j = mid;
        int k = 0;
        while (i < mid && j < high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        int start = i;
        int end = mid;
        if (j < high) {
            start = j;
            end = high;
        }

        while (start < end) {
            temp[k++] = a[start++];
        }

        System.arraycopy(temp,0,a,low,length);
    }

    @Benchmark
    public void testQuickSort(){
        int[] a=new int[1000];
        Random random=new Random(201907023);
        for(int i=0;i<a.length;i++){
            a[i]=random.nextInt(1000);
        }
        quickSort(a);
    }

    @Benchmark
    public void testMergeSort(){
        int[] a=new int[1000];
        Random random=new Random(201907023);
        for(int i=0;i<a.length;i++){
            a[i]=random.nextInt(1000);
        }
        mergeSort(a);
    }
    @Benchmark
    public void testArraysSort(){
        int[] a=new int[1000];
        Random random=new Random(201907023);
        for(int i=0;i<a.length;i++){
            a[i]=random.nextInt(1000);
        }
        Arrays.sort(a);
    }
}
