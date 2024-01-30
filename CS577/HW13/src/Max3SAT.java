import java.util.Scanner;
import java.util.Random;

public class Max3SAT {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int n = scnr.nextInt();
		int m = scnr.nextInt();
		boolean[] x = new boolean[n];
		int[][] clauses = new int[m][3];
		Random rand = new Random();
		//int[] bin = {-1, 1};
		for (int i = 0; i < m; i++) {
			clauses[i][0] = scnr.nextInt();
			clauses[i][1] = scnr.nextInt();
			clauses[i][2] = scnr.nextInt();
		}
		// for (int attempts = 0; attempts < 8 * m; attempts++) {
		int count = 0;
		while (count < (7 * m) / 8) {
			count = 0;
			for (int i = 0; i < n; i++) {
				x[i] = rand.nextBoolean();
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < 3; j++) {
					if (clauses[i][j] < 0) {
						if (!x[Math.abs(clauses[i][j]) - 1]) {
							count += 1;
							break;
						}
					} else {
						if (x[clauses[i][j] - 1]) {
							count += 1;
							break;
						}
					}
				}
				if (count >= (7 * m) / 8) {
					break;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (x[i]) {
				System.out.print("1");
			}
			else {
				System.out.print("-1");
			}
			if (i != n - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
		scnr.close();
	}
}
