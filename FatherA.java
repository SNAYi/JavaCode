public class FatherA {
	//构造方法
   public FatherA() {
	   System.out.println("1.父类A构造方法");
   }
   //非静态代码块
   {
	   System.out.println("2.父类A非静态代码块");
   }
   //静态代码块
   static {
	   System.out.println("3.父类A静态代码块");
   }
}