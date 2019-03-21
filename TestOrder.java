import java.util.Scanner;
public class TestOrder{
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		/*Goods goods =new Goods("T恤",245,2);
		String s = goods.toString();
		System.out.println(s);
		*/
		
		//1.创建一个订单
		Bill bill =new Bill();
		
		//2.实例化一个商品数组
		Goods[] goodsArray = new Goods[3];
		bill.setGoodsArray(goodsArray);
		//传入商品信息
		for(int i = 0;i < goodsArray.length;i++) {
			System.out.println("请输入商品信息(物品 单价 个数)");
			//从命令行输入商品信息
			String line = scanner.nextLine();
			//将一个商品信息按空格分成3份，放入一个字符串数组
			String[] segments = line.split(" ");
		//商品数组的赋值,存在类型强转
			goodsArray[i] = new Goods(segments[0],
									Double.parseDouble(segments[1]),
									Integer.parseInt(segments[2]));
		}
		
		//3.折扣信息
		System.out.println("请输入折扣：");
		String discount = scanner.nextLine();
		bill.setDiscount(Integer.parseInt(discount));
		
		//打印消费总金额好让顾客输入实付金额
		Double b = bill.getTotalPrice();
		System.out.println("消费总金额："+b);
		//输入实付金额
		System.out.println("请输入实际交费：");
		String realPay =scanner.nextLine();
		bill.setRealPay(Double.parseDouble(realPay));
		
		//4.打印订单
		System.out.print(bill.toString());
	}
}

//账单
class Bill{
	//折扣,初始化默认不打折
	private  Integer discount = 10;
	//实付金额
	private Double realPay;
	//商品信息
	private Goods[] goodsArray ;
	
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public void setRealPay(Double realPay) {
		this.realPay = realPay;
	}
	public void setGoodsArray(Goods[] goodsArray) {
		this.goodsArray = goodsArray;
	}
	
	
	//折后实际消费金额
	public Double getTotalPrice(){
		Double real = 0.0d;
		for(int i = 0;i < goodsArray.length;i++) {
			real = real + goodsArray[i].getTotalPrice();
		}
		return real*this.discount*0.1d;
	}
	
	
	
	//找钱
	public Double change() {
		return this.realPay - this.getTotalPrice();
	}
	//字符串账单
	public String toString() {
		StringBuilder a = new StringBuilder();
		 a.append("**********消费单**********").append("\n")
		  .append("物品\t单价\t个数\t金额").append("\n");
		  for(int i = 0;i < goodsArray.length;i++) {
			  a.append(goodsArray[i].toString()).append("\n");
		  }
		  a.append("\n")
		   .append("折扣：").append(this.discount).append("折").append("\n")
		   .append("消费总金额：").append(this.getTotalPrice()).append("\n")
		   .append("实际交费：").append(this.realPay).append("\n")
		   .append("找钱：").append(this.realPay - this.getTotalPrice()).append("\n")
		   .append("本次购物所获积分是：").append(this.getTotalPrice()*0.1);
			
		return a.toString();
		}
}
//商品类
class Goods {
	//成员属性
	//商品名
	private String name;
	//单价
	private Double price;
	//个数
	private Integer number;

	//构造方法,可以达到setter方法的作用，不再另写setter
	public Goods(String name,Double price,Integer number) {
			this.name = name;
			this.price =price;
			this.number = number;
	}
	//计算金额
	public Double getTotalPrice() {
		return this.price*this.number;
	}
	//取代getter方法
	public String toString() {
		return this.name +"\t"
			+"￥"+ this.price +"\t"
			+ this.number +"\t"
			+"￥"+this.getTotalPrice();
	}

}
