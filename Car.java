public class Car {
	//属性
	//发动机编号 
	//成员变量被private修饰之后，只能在类的内部允许被访问
	private String engineNumber;
	
	//品牌
	private String brand;
	
	//颜色
	private String color;
	
	//true自动挡 false 手动挡
	private boolean autoType;
	
	//构造方法
	public Car(String engineNumber) {
		//左边this.* 指的是成员属性里面的*，右边*是形参传进来的
		this.engineNumber = engineNumber;
	}
	public String getEngineNumber() {
		//返回之后指向了成员属性
		return this.engineNumber;
	}
	
	public String getBrand() {
		return this.brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	//boolean类型的访问成员变量要用 isxxx
	//boolean类型默认值是false
	public boolean isAutoType() {
		return this.autoType;
	}
	public void setAutoType(boolean autoType) {
		this.autoType = autoType;
	}
	
	public String getCarInfo() {
		// 有的是通过调用方法访问成员属性，有的是直接访问成员属性
		return "发动机编码是：" + this.getEngineNumber() + "\n"
				+ "品牌是：" + this.brand + "\n" 
				+ "颜色是：" + this.autoType + "\n"
				+ "是否自动挡:" + this.isAutoType() + "\n";
								
			  
	}
	
	//行为(功能)
	public void drive() {
		System.out.println("向前开：道路千万条 安全第一条");
		if(this.isAutoType() == true) {
			System.out.println("自动挡 好开");
		} else {
			System.out.println("手动挡 难开");
		}
	}
	
	public void back() {
		System.out.println("倒车请注意");
	}
	
	public static void main(String[] args) {
		Car qrqq = new Car("qq100010"); 
		qrqq.drive();
		qrqq.setBrand("奇瑞QQ");
		qrqq.setColor("黄色");
		qrqq.setAutoType(true);
		qrqq.drive();
		System.out.println(qrqq.getCarInfo());
	}
}
	
