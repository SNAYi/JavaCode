public class TestB extends FatherA{
	//构造方法
	public TestB() {
		System.out.println("4.B构造方法");
	}
	//非静态代码块
	{
		System.out.println("5.B非静态代码块");
	}
	//静态代码块
	static {
		System.out.println("6.B静态代码块");
	}
	
	public static void main(String[] args) {
		System.out.println("7.开始");
		//匿名对象,执行TestB前会先继承FatherA,执行FatherA的代码
		new TestB();
		System.out.println("8.结束");
	}
}