class Father{
	public void print() {
		System.out.println("父类print方法");
	}
}

class Son extends Father{
	//override覆写
	public void print() {
		System.out.println("子类print方法");
	}
	//子类扩充
	public void fun() {
		System.out.println("子类扩充的fun方法");
	}
}

public class TestDown2{
	public static void main(String[] args) {
		//向上转型
		Father father = new Son();
		//向下转型之前利用instanceof 关键字判断 father 是由哪个类实例的
		//结果：都输出 true
		System.out.println(father instanceof Father);
		System.out.println(father instanceof Son);
		//判断安全，才调用Son方法
		if(father instanceof Son) {
			//向下转型
			Son son =(Son)father;
			son.fun();
		}
	}
}