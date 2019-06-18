import java.util.Scanner;
public class CountRubbit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         while (sc.hasNextInt()) {
        int month = sc.nextInt();
        System.out.println(count(month));
         }
        sc.close();
    }
    public static int count(int month){
        if(month==1||month==2){
            return 1;
        }
        if(month == 0 ){
            return 0;
        }
        else{
        return count(month-1)+count(month-2);
        }
    }
}