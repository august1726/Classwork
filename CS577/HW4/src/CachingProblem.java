//import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.HashMap;

public class CachingProblem {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int inst = Integer.parseInt(scnr.nextLine());
		for (int i = 0; i < inst; i++) {
			int pages = Integer.parseInt(scnr.nextLine());
			int requests = Integer.parseInt(scnr.nextLine());
			String[] line = scnr.nextLine().split(" ");
			int fault = 0;
			PriorityQueue<String> queue = new PriorityQueue<String>();
			HashMap<String, PriorityQueue<Integer>> totals = new HashMap<String, PriorityQueue<Integer>>();
			for (int j = 0; j < requests; j++) {
				if (!totals.containsKey(line[j])) {
					totals.put(line[j], new PriorityQueue<Integer>());
				}
				totals.get(line[j]).add(j);
			}
			for (int j = 0; j < requests; j++) {
				if (!queue.contains(line[j])) {
					//System.out.println(queue.toString());
					fault++;
					if (queue.size() == pages) {
						int max = -1;
						String rem = queue.peek();
						for(String s : queue) {
							boolean lessForAll = true;
							for (int c : totals.get(s)) {
								//System.out.print(s + " ");
								//System.out.println(c + " " + j);
								if (c - j > 0) {
									lessForAll = false;
									if (c - j > max) {
										max = c - j;
										rem = s;
									}
									break;
								}
							}
							if (lessForAll) {
								rem = s;
								break;
							}
						}
						//System.out.println(rem);
						queue.remove(rem);
					}
					queue.add(line[j]);
				}
			}
			System.out.println(fault);
		}
		scnr.close();
	}
}
