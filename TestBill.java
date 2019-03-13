public class TestBill{
	public static void main(String[] args) {

	Bill2 tShirt = new Bill2("T恤",245);
	tShirt.setNumber(2);
	
	Bill2 tennisShoes = new Bill2("网球鞋",570);
	tennisShoes.setNumber(1);
	
	Bill2 tennisRacket = new Bill2("网球拍",320);
	tennisRacket.setNumber(1);
	
	System.out.println("**********消费单**********");
	System.out.println("物品" + "\t" + "单价" + "\t" + "个数" + "\t" + "金额");
	tShirt.print();
	tennisShoes.print();
	tennisRacket.print();
	
	System.out.println();
	
	System.out.println("折扣："+ tShirt.getDiscount()*10 + "折");
	//总钱数
	 int totalMoney = tShirt.getMoney() + tennisShoes.getMoney() + tennisRacket.getMoney();
	System.out.println("消费总金额：" + totalMoney*tShirt.getDiscount());
	//交的钱
	tShirt.setReceivedMoney(1500);
	System.out.println("实际缴费：" +tShirt.getReceivedMoney());
	
	System.out.println("找钱：" +( tShirt.getReceivedMoney() - totalMoney*tShirt.getDiscount()));
	System.out.println("本次购物所获的积分是:" + 33);
	}
	
}