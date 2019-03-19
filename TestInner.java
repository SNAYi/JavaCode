class A {
	private String name = "A的私有属性";
	public String getName() {
		return this.name;
	}
}

class B {
	private int age = 20;
	public int getAge() {
		return this.age;
	}
}

class Outter{
	//内部类
	private class InnerClassA extends A{
		public String name() {
			return super.getName();
		}
	}
	//内部类
	public class InnerClassB extends B {
		private int age() {
			return super.getAge();
		}	
	}
	//Outter的方法,返一个newInnerClassA对象的方法,间接返回A类里的name私有属性
	public String name() {
		return new InnerClassA().name();
	}
	//Outter的方法
	public int age() {
		return new InnerClassB().age();
	}

} 

public class TestInner{
	public static void main(String[] args){
		Outter outter = new Outter();
		System.out.println(outter.name());
		System.out.println(outter.age());
	}
}