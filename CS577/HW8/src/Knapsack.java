import java.util.Scanner;
//import java.util.HashMap;

public class Knapsack {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int inst = Integer.parseInt(scnr.nextLine());
		for (int i = 0; i < inst; i++) {
			int items = scnr.nextInt();
			int capacity = scnr.nextInt();
			scnr.nextLine();
			int[][] arr = new int[items + 1][capacity + 1];
			int[][] list = new int[items + 1][2];
			for(int j = 1; j <= items; j++) {
				list[j][0] = scnr.nextInt();
				list[j][1] = scnr.nextInt();
				scnr.nextLine();
			}
			for (int j = 1; j <= items; j++) {
				for (int k = 1; k <= capacity; k++) {
					//int indicator = 1;
					if (list[j][0] > k) {
						arr[j][k] = arr[j-1][k];
					}
					else {
						arr[j][k] = Math.max(arr[j-1][k], (arr[j-1][k - list[j][0]] + list[j][1]));
					}
				}
			}
			System.out.println(arr[items][capacity]);
		}
		scnr.close();
	}
}
