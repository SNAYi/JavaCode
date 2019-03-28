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

public class TestDown{
	public static void main(String[] args) {
		//向上转型
		Father father = new Son();
		//执行的是:子类print方法
		father.print();
		//必须向下强转
		Son son =(Son)father;
		son.fun();
	}
}