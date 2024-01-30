import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.HashMap;

public class LineIntersections {
	public static long intersections;
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int inst = Integer.parseInt(scnr.nextLine());
		for (int i = 0; i < inst; i++) {
			intersections = 0;
			int n = Integer.parseInt(scnr.nextLine());
			PriorityQueue<Long> q = new PriorityQueue<Long>();
			HashMap<Long, Long> map = new HashMap<Long, Long>();
			Long[] top = new Long[n];
			for (int j = 0; j < n; j++) {
				top[j] = Long.parseLong(scnr.nextLine());
			}
			for (int j = 0; j < n; j++) {
				q.add(top[j]);
				map.put(top[j], Long.parseLong(scnr.nextLine()));
			}
			Long[][] arr = new Long[n][1];
			for (int j = 0; j < n; j++) {
				arr[j] = new Long[]{map.get(q.poll())};
			}
			while(arr.length > 1) {
				Long[][] arr2 = new Long[arr.length / 2 + arr.length % 2][1];
				for(int j = 0; j < arr.length; j+=2) {
					Long[] a = arr[j];
					if (j == arr.length - 1) {
						arr2[j/2] = a;
						break;
					}
					Long[] b = arr[j + 1];
					arr2[j/2] = (merge(a, b));
				}
				arr = arr2;
			}
			System.out.println(intersections);
		}
		scnr.close();
	}
	
	public static Long[] merge(Long[] a, Long[] b) {
		int a_count = 0;
		int b_count = 0;
		int ind = 0;
		Long[] arr = new Long[a.length + b.length];
		while(b_count < b.length && a_count < a.length) {
			if (a[a_count] <= b[b_count]) {
				arr[ind] = a[a_count];
				ind++;
				a_count++;
			}
			else {
				arr[ind] = b[b_count];
				ind++;
				b_count++;
				intersections+= a.length - a_count;
			}
		}
		while (b_count < b.length) {
			arr[ind] = b[b_count];
			ind++;
			b_count++;
		}
		while (a_count < a.length) {
			arr[ind] = a[a_count];
			ind++;
			a_count++;
		}
		return arr;
	}
}
