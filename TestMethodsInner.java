class Outter{
	private int num=1111;
	public void display(int test) {
		class Inner{
			private void fun() {
				num++;
				System.out.println(num);
				//方法内部类想要访问方法的形参，需要形参被final修饰
				System.out.println(test);
			}
		}
		//创建一个匿名Inner对象，执行fun方法;需要在方法里,方法外看不到Inner类
		new Inner().fun();
	}
}

public class TestMethodsInner{
	public static void main(String[] args) {
		Outter outter =new Outter();
		outter.display(30);
	}
}
