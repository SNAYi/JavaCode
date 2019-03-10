public class Student {
	//属性
	private String name;
	private int age;
	//static修饰的静态私有属性 即 类属性
	private static String studentId ="164010101";
	
	//构造方法
	//1.无参构造方法
	public Student(){
		
	}
	//2.一个参数的构造方法
	public Student(String name){
		this.name = name;
		System.out.println("一个参数的构造方法被调用");
	}
	//3.两个参数的构造方法被调用
		public Student(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("两个参数的构造方法被调用");
	}
	
	//普通方法
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	
	public String getStudentInformation() {
		return "姓名:" + this.getName() + "  年龄:" + this.getAge() + "  学号:" + this.studentId;
	}
}