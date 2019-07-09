import java.util.*;
public class TestBreak{
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("i的值为"+i+"j的值为"+j);
                if (j==1) {
                    break outer;
                }
            }
            
            System.out.println("break outer只跳出了本次循环");
        }
        System.out.println("break outer跳出outer标签所在的外循环");
    }
}