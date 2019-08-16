/**
 * @Author: snayi
 * @CreateTime: 2019-08-16 00:40
 * @Description:  在一个数组中，找到第K大的数
 */
import java.util.*;

public class Finder {
    public int findKth(int[] a, int n, int K) {
        return findKth(a,0,n-1,K);
    }
    public int findKth(int[] a, int low,int high, int K) {
        int pivotIndex = partion(a,low,high);
        if(pivotIndex-low+1 == K) {
            return a[pivotIndex];
        } else if(pivotIndex <= pivotIndex-low+1) {
            //去前半段遍历找
            return findKth(a,low,pivotIndex-1,K);
        } else {
            //去后半段遍历找
            return findKth(a,pivotIndex+1,high,K-(pivotIndex-low+1));
        }
    }
    //找第K大，降序排列
    public int partion(int[] a,int low,int high) {
        int key = a[low];
        while(low < high) {
            while(low < high && a[high] <= key)
                high--;
            a[low] = a[high];
            while(low < high && a[low] >= key)
                low++;
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }
}

/*
public class Finder {
    public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n-1, K);
    }
    public int findKth(int[] a, int low, int high, int k) {
        int part = partation(a, low, high);
        if(k == part - low + 1) return a[part];
        else if(k > part - low + 1) return findKth(a, part + 1, high, k - part + low -1);
        else return findKth(a, low, part -1, k);
    }
    public int partation(int[] a, int low, int high) {
        int key = a[low];
        while(low < high) {
            while(low < high && a[high] <= key) high--;
            a[low] = a[high];
            while(low < high && a[low] >= key) low++;
            a[high] = a[low];
        } a
                [low] = key;
        return low;
    }
}*/
