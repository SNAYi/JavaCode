public class Bill2{

		//物品
		private String goods;
		//单价
		private int price;
		//个数
		private int number;
		//金额,不需要设置，用单价乘以个数就好，只需要getter方法
		private int money;
		//折扣,设置为8折，不可修改
		public  final float discount = 0.8f;
		//消费总金额,物品总金额之和，只需要getter方法
		private   int totalMoney;
		//收到的钱
		private  int receivedMoney;
		//找钱
		private  int change;
		
		//构造器
		public Bill2(String goods,int price){
		this.goods = goods;
		this.price = price;
		}
		
		 public String getGoods() {
			 return this.goods;
		 }
		 
		 public int getPrice() {
			 return this.price;
		 }
		 
		  public void setNumber(int number){
			 this.number = number;
		 }
		 public int getNumber() {
			 return this.number;
		 }
		 
		 public int getMoney(){
			 return this.price *this.number;
		 }
		 
		 public  float getDiscount(){
			 return this.discount;
		 }
		 
		 public void setTotalMoney(int totalMoney){
			 this.totalMoney = totalMoney;
		 }
		 public int getTotalMoney(){
			 return this.totalMoney;
		 }
		 
		 public void setReceivedMoney(int receivedMoney){
			 this.receivedMoney = receivedMoney;
		 }
		 public int getReceivedMoney(){
			 return this.receivedMoney;
		 }
		 
		  public void setChange(int change){
			 this.change = change;
		 }
		 public int getChange(){
			 return this.change;
		 }
		 public String getGoodsInformation() {
			 return this.getGoods() +"\t"
			 + this.getPrice() + "\t"
			 + this.getNumber() + "\t"
			 + this.getMoney();
		}
	 
		 public void print() {
			String info = getGoodsInformation();
			System.out.println(info);
		 }


}