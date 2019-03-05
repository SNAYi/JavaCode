public class NFactorial {
	public static void main(String[] args) {
		//用递归求n！
		int n = 10;
		int result = factorial(10);
		System.out.println("1*2*3*...*"+ n + "=" + result);
	}
	public static int factorial(int n){
		//出口
		if(n == 1 || n== 0) {
			return 1;
		} else {
			return (n * factorial(n-1));
		}
	}
}