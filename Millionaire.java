import java.util.*;
public class Millionaire {
    public static void main(String[] args) {
        //strange是陌生人，rich是有钱人，strange每天给rich 10万元，rich第一天给2分，第二天给4分
        int strange = 0;
        int rich = 0 ;
        strange = 10*30; //万元
        rich =(int)( Math.pow(2,30) - 1);
        System.out.print(strange + " " + rich);
    }
}