package java;

public class P258_AddDigits {
	public int addDigits(int num) {
		int r = num % 9;
		return (num == 0) ? 0 : (r == 0) ? 9 : r;
	}
}
