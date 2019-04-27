/**
 * @auther SNAYi
 *@describe There are ten people in a circle. Counting from the first person (counting from 1 to 3),
 * the person who reported 3 withdrew from the circle and asked which number he had left behind.
 * @date 2019/4/27 下午 08:32
 */
public class CallNumber {
    public static void main(String[] args) {
        System.out.println(callSurvivalNumber(10));
        System.out.println(callSurvivalNumber(1));
        System.out.println(callSurvivalNumber(0));
        System.out.println(callSurvivalNumber(-1));
    }

    //序号  0 1 2 3 4 5 6 7 8 9
    //人名  1 2 3 4 5 6 7 8 9 0
    //报数  1 2 - 1 2 - 1 2 - 1
    //报数  2 -   1 2   - 1   2
    //报数  -     1 2     -   1
    //报数        2 -         1
    //报数        2           -
    /**
     * @param count The total number of people in a circle
     * @return the last person
     */
    public static int callSurvivalNumber(int count) {
        //1.校验合法性
        if (count <= 0) {
            throw new UnsupportedOperationException("can not into a circle");
        }
        //2.创建一个数目为count的boolean[],设置初始状态true，表名每个人都在圈里
        boolean[] peopleStates = new boolean[count];
        for (int i = 0; i < peopleStates.length; i++) {
            peopleStates[i] = true;
        }
        int index = -1;
        int counter = 0; //退出圈子的人数
        int current = 0; //当前人报的数
        while(counter < peopleStates.length - 1) {
            //3.先让其成环
            index = (index + 1) % peopleStates.length;
            //如果这个人已经退圈，就跳过他走向下一个人
            if (peopleStates[index] == false) {
                continue;
            }
            //4.index报的数为
            current = (current +1) % 3;
            if (current == 0) {
                peopleStates[index] = false;
                counter++;
            }
        }
        int i = 0;
        for (; i < peopleStates.length; i++) {
            if (peopleStates[i] == true) {
                return i+1;
            }
        }
        throw new RuntimeException("not found");
    }
}
