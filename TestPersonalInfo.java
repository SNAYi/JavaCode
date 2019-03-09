public class TestPersonalInfo{
	public static void main(String[] args) {
		PersonalInfo p1;
		//当在执行时从命令行输入chinese时,执行中文版个人信息，否则执行英文版信息
		if(args.length == 1 && args[0].equals("chinese")) {
			p1 = new ChinesePersonalInfo("张三",true);
		} else {
			p1 = new PersonalInfo("张三",true);
		}
		p1.setPost("Director");
		p1.setAge(18);
		p1.setTel("110");
		p1.setAdress("西安");
		p1.print();
	}
}

class PersonalInfo {
	
	//属性
	private  String name;
	private String post;
	private boolean sex;
	private int age;
	private String tel;
	private String adress;
	
	//构造方法
	public PersonalInfo(String name,boolean sex) {
		this.name = name;
		this.sex = sex;
	}
	//姓名
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//职业
	public String getPost() {
		return this.post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	//性别
	public boolean isSex() {
		return this.sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	//年龄
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//电话
	public String getTel() {
		return this.tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	//地址
	public String getAdress() {
		return this.adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getInfo() {
		return "Name:" + this.getName() + "\t" +
			  "Post:" + this.getPost() + "\n" +
			  "Sex:" + (this.isSex()?"female":"male") +"\t" +
			  "Age:" + this.getAge() +"\n" +
			  "Tel:" + this.getTel()+"\t" +
			  "Adress:" + this.getAdress()+ "\n";
	}
	public void print() {
		String info = getInfo();
		System.out.println(info);
	}
}

//为了可以输出中文版本个人信息(默认输出英文版个人信息) 
//写一个继承的中文信息子类
class ChinesePersonalInfo extends PersonalInfo{
	//构造方法,因为父类是有参构造方法，那么子类也必须是有参构造方法
	public ChinesePersonalInfo(String name,boolean sex) {
		//调用父类，要用super
		super(name,sex);
	}
		public String getInfo() {
		return "姓名:" + this.getName() + "\t" +
			  "职务:" + this.getPost() + "\n" +
			  "性别:" + (this.isSex()?"female":"male") +"\t" +
			  "年龄:" + this.getAge() +"\n" +
			  "电话:" + this.getTel()+"\t" +
			  "地址:" + this.getAdress()+ "\n";
	}
}