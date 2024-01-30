import java.util.Scanner;
import java.util.Arrays;

public class Attempt2 {
	public static Long inversions;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int inst = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < inst; i++) {
				inversions = 0l;
				int count = Integer.parseInt(sc.nextLine());
				String[] line = sc.nextLine().split(" ");
				Long[] list = new Long[count];
				for (int j = 0; j < count; j++) {
					list[j] = Long.parseLong(line[j]);
				}
				countSort(list);
				System.out.println(inversions);
			}
			sc.close();

	}
	
	public static Long[] countSort(Long[] a) {
		if (a.length == 1) {
			return a;
		}
		Long[] a1 = countSort(Arrays.copyOfRange(a, 0, a.length / 2));
		Long[] a2 = countSort(Arrays.copyOfRange(a, a.length / 2, a.length));
		a = mergeCount(a1, a2);
		return a;
	}
	
	public static Long[] mergeCount(Long[] a1, Long[] a2) {
		Long[] a = new Long[a1.length + a2.length];
		int ind1 = 0;
		int ind2 = 0;
		int ind = 0;
		while (ind1 < a1.length && ind2 < a2.length) {
			if(a1[ind1] <= a2[ind2]) {
				a[ind] = a1[ind1];
				ind++;
				ind1++;
			}
			else {
				inversions += a1.length;
				a[ind] = a2[ind2];
				ind++;
				ind2++;
			}
		}
		while (ind1 < a1.length) {
			a[ind] = a1[ind1];
			ind++;
			ind1++;
		}
		while (ind2 < a2.length) {
			a[ind] = a2[ind2];
			ind++;
			ind2++;
		}
		return a;
	}
}
