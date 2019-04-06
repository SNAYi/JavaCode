interface USB{
	void setUp();
	void work();
}

class Computer{
	//电脑使用USB标准，识别实现了USB接口的类
	public void plugIn(USB sub) {
		sub.setUp();
		sub.work();
	}
}
class UDisk implements USB{
	public void setUp(){
		System.out.println("安装U盘驱动");
	}
	public void work() {
		System.out.println("使用U盘");
	}
}
public class TestInterface1{
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.plugIn(new UDisk());
	}
}