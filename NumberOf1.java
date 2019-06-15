//思路一：
public class NumberOf1 {
	public int NumberOf1(int n) {
		int count = 0;
		int tag = 1;
		while (tag != 0) {
			if ((n & tag) != 0) {
				count++;
			}
			tag = tag << 1;
		}
		return count;
	}
	//思路二
	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}
}