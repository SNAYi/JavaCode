public class TestReferenceTransfer{
	public static void swap(DateSwap ds){
		int tmp = ds.a;
		ds.a = ds.b;
		ds.b = tmp;
		System.out.println("swap方法里的成员变量a = " + ds.a +";b = " + ds.b);
		
	}
	//结论：引用数据类型的参数传递的确也是值传递
	
	//引用数据类型同样开辟了main，swap两个栈空间
	//只不过引用数据类型栈空间存放的是引用变量dw地址，堆空间放的是new的DateSwap对象
	//swap方法拿着地址找到堆空间DateSwap对象，并改变了对象里变量值
	//所以：swap方法里的成员变量a = 10;b = 5
		//  交换后的a = 10;b = 5	
	public static void main(String[] args){
		DateSwap ds = new DateSwap();
		ds.a = 5;
		ds.b = 10;
		swap(ds);
		System.out.println("交换后的a = " + ds.a +";b = " + ds.b);
	}
}

class DateSwap{
	int a;
	int b;
}