//有人要买东西
interface IBuy{
	//买什么东西
	void buyBuy();
}

//真实买东西的人(买家) 真实主题类
class RealBuyer implements IBuy{
	//覆写
	public void buyBuy(){
		System.out.println("买一个mac rubywoo");
	}
}

//代理去买东西  代理类
class ProxyBuyer implements IBuy{
	//需要一个买家,传入真实主题类
	private IBuy buyer;
	public ProxyBuyer(IBuy buyer){
		this.buyer = buyer;
	}
	public void beforeBuy(){
		System.out.println("买家打钱");
	}
	public void afterBuy(){
		System.out.println("代理寄东西");
	}
	//覆写
	public void buyBuy(){
		this.beforeBuy();
		this.buyer.buyBuy();
		this.afterBuy();
	}
}

public class TestProxyDesignPattern{
	//客户端
	public static void main(String[] args) {
		IBuy buyer = new ProxyBuyer(new RealBuyer());
		buyer.buyBuy();
	}
}