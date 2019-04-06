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
//工厂类
class ComputerFactory{
	public static Computer getInstance(String computerName) {
		if(computerName.equals("mac")){
			return new MacSurface();
		} else 
			return null; 
	}
}


public class TestSimpleFactoryModel{
	//客户端
	public static void main(String[] args) {
		Client client = new Client();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你要购买的电脑");
		String computerName =scanner.nextLine();
		
		Computer computer = ComputerFactory.getInstance(computerName);
		client.buyComputer(computer);
	}
}