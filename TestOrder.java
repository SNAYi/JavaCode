public class TestOrder{
	public static void main(String[] args) {
		Goods goods =new Goods("T恤",245,2);
		String s = goods.toString();
		System.out.println(s);
	}

}

//账单
class Bill{
	//折扣,初始化默认不打折
	private  Integer discout = 10;
	//实付金额
	private double realPay;
	//找零
	private double change;
}
//商品类
class Goods {
	//成员属性
	//商品名
	private String name;
	//单价
	private double price;
	//个数
	private Integer number;

	//构造方法,可以达到setter方法的作用，不再另写setter
	public Goods(String name,double price,Integer number) {
			this.name = name;
			this.price =price;
			this.number = number;
	}
	//计算金额
	public double getTotalPrice() {
		return this.price*this.number;
	}
	//取代getter方法
	public String toString() {
		return this.name +"\t"
			+ this.price +"\t"
			+ this.number +"\t"
			+this.getTotalPrice();
	}

}
