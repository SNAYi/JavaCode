import java.util.*;
public class TestTemplateDesignPattern{
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		coffee.prepare();
	}
}
abstract class Drink{
	//模板方法
	public final void prepare(){
		boilWater();
		addMaterial();
		pourInCup();
		if(this.isAddMinorMaterial()){
		addMinorMaterial();
		}
	}
	/*public final void boilWater() {
		System.out.println("1.烧水");
	} */
	
	//这里可以在子类里面再扩展，不再被final修饰
	public void boilWater() {
		System.out.println("1.烧水");
	}
	public final void pourInCup() {
		System.out.println("3.倒入杯子");
	}
	public abstract void addMaterial();
	public abstract void addMinorMaterial();
	
	//可被子类覆写，默认执行加辅料
	public boolean isAddMinorMaterial() {
		return true;
	}
}
class Coffee extends Drink{
	public void boilWater() {
		//先继承父类基础的烧水功能
		super.boilWater();
		System.out.println("1.1水不能太开，烫");
	}
	public void addMaterial() {
		System.out.println("2.将咖啡倒入水中");
	}
	public void addMinorMaterial() {
		System.out.println("4.给咖啡中加糖");
	}
	public boolean isAddMinorMaterial() {
      System.out.println("是否添加辅料？(请输入：yes/no)");
	  Scanner scanner = new Scanner(System.in); 
	  String choose = scanner.next();
	  if(choose.equals("yes")) {
		return true;  
	  } else{
		  return false;
	  }
	  
	}
}