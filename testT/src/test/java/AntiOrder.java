/**
 * @Author: snayi
 * @CreateTime: 2019-08-16 22:00
 * @Description: 数组中的逆序对
 *                  有一组数，对于其中任意两个数，若前面一个大于后面一个数字，则这两个数字组成一个逆序对
 */
public class AntiOrder {
    public int count(int[] A, int n) {
        int count = 0;
        if(!(n <= 0 || n > 5000)){
            for(int i = 0;i < n-1;i++) {
                int temp = A[i];
                for(int j = i+1;j < n;j++) {
                    if(temp > A[j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        AntiOrder a = new AntiOrder();
        int[] A = new int[]{1,2,3,4,5,6,7,0};
        System.out.println("此数组中逆序对的个数为："+a.count(A,A.length));

    }
}
