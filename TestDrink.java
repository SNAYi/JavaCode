import java.util.Scanner;
abstract class Drink {
    //核心算法 制作流程不希望被改变，用final 修饰
    final void prepareRecipe() {
        blowWater();
        brew();
        pourInCup();
		//是否添加辅料看用户选择
        if (customersChoose()){
            addCodiments();
        }
    }
    public final void blowWater() {
        System.out.println("烧水");
    }
    public final void pourInCup() {
        System.out.println("倒入杯中");
    }

    //子类必须覆写
    abstract void brew();
    abstract  void addCodiments();
	
    //子类选择覆写，hook方法
    public boolean customersChoose() {
        return true;
    }
}

class Coffee extends Drink {
    public void brew() {
        System.out.println("用水煮咖啡");
    }
    public void addCodiments() {
        System.out.println("咖啡里加糖");
    }
	public boolean customersChoose(){
		System.out.println("是否选择加糖,y表示加，n表示不加");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		if(str.equals("y")){
			return true;
		} else {
			return false;
		}
		
	}
}

public class TestDrink {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
		coffee.prepareRecipe();
    }
}
