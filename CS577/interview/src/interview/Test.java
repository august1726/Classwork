package interview;

public class Test {
	public static void main(String[] args) {
		int a = 1;
		int b = 4;
		
	}
	
	public static long multiply(int a, int b) {
		long c = 0;
		
		if (b < a) {
			for (int i = 0; i < b; i++) {
				c +=a;
			}
		}
		else {
			for (int i = 0; i < a; i++) {
				c +=b;
			}
		}
		
		return c;
	}
}
