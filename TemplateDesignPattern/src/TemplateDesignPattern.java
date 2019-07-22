/**
 * @Author: snayi
 * @CreateTime: 2019-07-22 23:20
 * @Description:
 */

class ProductTea extends DrinkProduction{

    @Override
    void brew() {
        System.out.println("2.用水冲泡茶");
    }

    @Override
    void addCondiments() {
        System.out.println("3.加冰块");
    }
}
class ProductCoffee extends DrinkProduction{

    @Override
    void brew() {
        System.out.println("2.冲泡咖啡");
    }

    @Override
    void addCondiments() {
        System.out.println("4.加糖和牛奶");
    }
}
public class TemplateDesignPattern {
    public static void main(String[] args) {
        ProductTea tea = new ProductTea();
        ProductCoffee coffee = new ProductCoffee();
        tea.production();
        System.out.println("-------------");
        coffee.production();
    }
}
