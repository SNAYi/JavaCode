public class TestUSB {
	public static void main(String[] args) {
		Computer computer = new Computer();
		//一般使用1,2种，面向接口编程
		//实例化的第一种方法
		//computer.plugIn(new Printer());
		//实例化第二种方法
		/*
		USB printer = new Printer();
		computer.plugIn(printer);
		*/
		//实例化第三种方法
		Printer printer =new Printer();
		computer.plugIn(printer);
	}
}

interface USB {
	//接口里的全局变量和抽象方法省掉修饰词
	//安装驱动
	void setup();
	void work();
}

class Computer {
	//电脑只能接USB
	public void plugIn(USB usb) {
	usb.setup();
	usb.work();
	}
}

class Printer implements USB{
	public void setup() {
		System.out.println("打印机厂商提供的驱动");
	}
	public void work() {
		System.out.println("打印机开始工作");
	}
}