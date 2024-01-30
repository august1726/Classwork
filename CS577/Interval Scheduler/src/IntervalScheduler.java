import java.util.Scanner;
import java.util.PriorityQueue;

public class IntervalScheduler {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inst = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < inst; i++) {
			int jobs = Integer.parseInt(scan.nextLine());
			PriorityQueue<Job> queue = new PriorityQueue<Job>();
			for (int j = 0; j < jobs; j++) {
				queue.add(new Job(scan.nextInt(), scan.nextInt()));
				scan.nextLine();
			}
			int scheduled = 0;
			while(!queue.isEmpty()) {
				Job temp = queue.poll();
				scheduled++;
				while (!queue.isEmpty() && queue.peek().start < temp.end) {
					queue.poll();
				}
			}
			System.out.println(scheduled);
		}
		scan.close();
	}
}

class Job implements Comparable<Job>{
	public int start;
	public int end;
	
	public Job(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Job o) {
		if (o.end > this.end) {
			return -1;
		}
		else if (o.end < this.end) {
			return 1;
		}
		else {
			if (o.start > this.start) {
				return -1;
			}
			else if (o.start < this.start) {
				return 1;
			}
		}
		return 0;
	}
	
}