import java.util.Scanner;
//import java.util.Arrays;
import java.util.LinkedList;

public class InversionCounter {
	public static Long inversions;
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int inst = Integer.parseInt(scnr.nextLine());
		for (int i = 0; i < inst; i++) {
			int count = Integer.parseInt(scnr.nextLine());
			inversions = 0l;
			Long[][] list = new Long[count][1];
			for (int j = 0; j < count; j++) {
				list[j][0] = scnr.nextLong();
			}
			if (scnr.hasNextLine()) {
				scnr.nextLine();
			}
			while(list.length > 1) {
				
				Long[][] list2 = new Long[list.length / 2 + list.length % 2][1];
				for(int j = 0; j < list.length; j+=2) {
					Long[] a = list[j];
					if (j == list.length - 1) {
						//System.out.println(list2.length);
						list2[j/2] = a;
						break;
					}
					Long[] b = list[j + 1];
					list2[j/2] = (merge(a, b));
				}
				//while (!list.isEmpty()) {
				//	Long[] a = list.poll();
				//	if (list.isEmpty()) {
				//		list2.add(a);
				//		break;
				//	}
				//	Long[] b = list.poll();
				//	list2.add(merge(a, b));
				//}
				list = list2;
			}
			System.out.println(inversions);
			//System.out.print(Arrays.toString(list.get(0)));
		}
		scnr.close();
	}
	
	public static Long[] merge(Long[] a, Long[] b) {
		int a_count = 0;
		int b_count = 0;
		int ind = 0;
		Long[] arr = new Long[a.length + b.length];
		while(b_count < b.length && a_count < a.length) {
			//if (a[a_count] == b[b_count]) {
			//	long c = a[a_count];
			//	while (a_count < a.length && a[a_count] == c) {
			//		arr[ind] = c;
			//		a_count++;
			//		ind++;
			//	}
			//	while (b_count < b.length && b[b_count] == c) {
			//		arr[ind] = c;
			//		b_count++;
			//		ind++;
			//	}
			//}
			if (a[a_count] <= b[b_count]) {
				arr[ind] = a[a_count];
				ind++;
				a_count++;
			}
			else {
				arr[ind] = b[b_count];
				ind++;
				b_count++;
				inversions+= a.length - a_count;
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
			//inversions++;
		}
		return arr;
	}
	
}
