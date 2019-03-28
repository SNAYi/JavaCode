class Father{
	public void print(){
		System.out.println("父类print方法");
	}
}

class Son extends Father{
	//覆写
	public void print() {
		System.out.println("子类print方法");
	}
}
public class TestUpper{
public static void main(String[] args) {
	//子类向上转型,本质还是要看new的对象是什么类
   Father father = new Son();
   //1.Son覆写Father的print方法,则使用Son的print 
   //2.Son没覆写,则使用它从Father类继承来的print
   father.print();
}
}

