public class MultiplicationTable {
	public static void main(String args[]) {
		/**
		打印乘法表 x代表行 y代表列
		*/
		int product = 0;
		for(int x = 1;x <= 9;x++) {
			for(int y = 1;y <= x;y++ ) {
				product = y * x; 
				System.out.print(y + "*" + x + "=" + product +" ");
				
			}
			System.out.println();
		}
	}
}