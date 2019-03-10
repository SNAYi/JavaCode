public class TestStudent{
	//code1和code2的对比,演示了构造方法的重载
	
	//执行code1会输出：
	//一个参数的构造方法被调用
	//姓名:张三  年龄:11  学号:164010101
	public void code1() {
		Student s = new Student("张三");
		s.setAge(11);
		String info = s.getStudentInformation();
		System.out.println(info);
	}
	//执行code2会输出：
	//两个参数的构造方法被调用
	//姓名:李四  年龄:12  学号:164010101
	public void code2() {
		System.out.println(new Student("李四",12).getStudentInformation());
	}
	public static void main(String[] args) {
		//执行main方法会输出：
		//两个参数的构造方法被调用
		//姓名:王五  年龄:13  学号:164020202
		//两个参数的构造方法被调用
		//姓名:邓六  年龄:14  学号:164020202
		Student s = new Student("王五",13);
		//因为studentId这个Student类的属性被static修饰，所以它成为一个静态属性，不在堆上有内存
		//通过任意一个Student类的实例都可修改并且值会保留,直到下次修改
		s.setStudentId("164020202");
		String info = s.getStudentInformation();
		System.out.println(info);
		
		Student s2 = new Student("邓六",14);
		System.out.println(s2.getStudentInformation());
	}
}