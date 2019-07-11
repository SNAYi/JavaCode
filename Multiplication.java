/**
 * @Author: snayi
 * @CreateTime: 2019-07-10 12:01
 * @Description:    Print multiplication table
 */
public class Multiplication {
    public static void main(String[] args) {
        //确定行数
        for (int i = 1; i < 10; i++) {
            //确定每一行输出什么
            for (int j = 1; j <10 ; j++) {
                //每一行前i-1个式子后面要加，
                if (j<i) {
                    System.out.print(i+"*"+j+"="+i*j+", ");
                }
                //每一行最后一个式子后面不加，
                if (j==i) {
                    System.out.print(i+"*"+j+"="+i*j);
                }
                if (j >=i){
                    break;
                }
            }
            System.out.println();
        }
    }
}
