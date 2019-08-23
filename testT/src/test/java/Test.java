import java.util.Arrays;

/**
 * @Author: snayi
 * @CreateTime: 2019-08-17 18:04
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{-1,-2,-3,-5,3,7,1,2,5};
        System.out.println(Arrays.toString(a));
        int[] b = new int[a.length];
        int i = 0,j = 0;
        int[] c = new int[a.length];
        for (int k:a){
            if (k >= 0) {
                b[i++] = k;
            } else {
                c[j++] = k;
            }
        }
        i = 0;
        for (int k : b) {
            if (k != 0)
            a[i++] = k;
        }
        for (int k : c) {
            if (k != 0)
            a[i++] = k;
        }
        System.out.println(Arrays.toString(a));
    }
}
