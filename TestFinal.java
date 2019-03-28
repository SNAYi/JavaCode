public class TestFinal{
	public static void main(String[] args) {
		byte b1=1,b2=2,b3,b6,b8;
		final byte b4=4,b5=6,b7=9;
		//1.结果：false
		//原因：byte类型的操作数在进行运算操作时,操作数会变成int类型
		//		 运算结果也是int类型;  b3(byte) != (int) (b1+b2)
		b3=(b1+b2);
		//2.结果：true 
		//原因：b4 b5被final修饰，类型不会改变;且b6也是byte类型
		b6=b4+b5; 
		//3.结果：false
		//原因：从int转换到byte可能会有损失
		b8=(b1+b4);
		//4.结果：false
		//原因：不能给final变量b7分配值;从int转换到byte可能会有损失
		b7=(b2+b5);
		System.out.println(b3+b6);
	}
}
