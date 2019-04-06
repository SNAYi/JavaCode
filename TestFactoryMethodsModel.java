import java.util.Scanner;
//定义标准
interface Computer{
	void PrintRealComputer();
}
//用户购买（使用标准）
class Client{
	public void buyComputer(Computer computer){
		computer.PrintRealComputer();
	}
}
//实现接口
class MacSurface implements Computer{
	public void PrintRealComputer(){
		System.out.println("buy a macsurface");
	}
}
//接口工厂
interface ComputerFactory{
	Computer createComputer();
}
//实现接口
class MacComputerFactory implements ComputerFactory{
	public Computer createComputer(){
		return new MacSurface();
	}
}


public class TestFactoryMethodsModel{
	//客户端
	public static void main(String[] args) {
		Client client = new Client();
		ComputerFactory cf = new MacComputerFactory();
		client.buyComputer(cf.createComputer());
	}
}