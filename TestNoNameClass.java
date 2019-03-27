interface MyInterface{
	public void test();
}
class Outter{
	public void display(int test){
		//一个匿名方法，实现接口
		new MyInterface(){
			//覆写接口未实现方法
			public void test(){
				System.out.println("匿名内部类使用方法形参test："+test);
			}
		}.test();
	}
}
public class TestNoNameClass{
	public static void main(String[] args) {
		Outter outter = new Outter();
		outter.display(5555);
	}
}