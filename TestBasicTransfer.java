public class TestBasicTransfer{
	//结论：基本数据类型的参数传递是值传递
	//在main方法里调用Swap方法时，系统分别为main方法和Swap方法分配了两个栈空间
	//系统里存在2个a变量，2个b变量；交换的是Swap栈区的a,b变量
	public static void main(String[] args){
		BasicTransfer bt = new BasicTransfer();
		int a = 5;
		int b = 10;
		bt.Swap(a,b);
		System.out.println("交换完成后的a = " + a + ";b = " + b);
		
	}
}
class BasicTransfer{
	public void Swap(int a,int b){
		int temp = a;
		a = b;
		b = temp;
		System.out.println("swap方法里交换后的a = " + a + ";b = " + b );
	}
}