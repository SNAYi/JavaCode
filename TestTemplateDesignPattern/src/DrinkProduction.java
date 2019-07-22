/**
 * @Author: snayi
 * @CreateTime: 2019-07-22 23:20
 * @Description:
 */
public abstract class DrinkProduction {
    void production() {
        boilWater();
        brew();
        addCondiments();
        pourIntoGlass();
    }
    //定义流程
    void boilWater() {
        System.out.println("1.烧水");
    }
    abstract void brew();
    abstract void addCondiments();
    void pourIntoGlass() {
        System.out.println("4.倒入杯子");
    }
}
