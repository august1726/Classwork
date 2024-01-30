import java.util.Scanner;
import java.lang.Comparable;
import java.util.PriorityQueue;

public class WIS {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int inst = Integer.parseInt(scnr.nextLine());
		for (int i = 0; i < inst; i++) {
			int count = Integer.parseInt(scnr.nextLine());
			PriorityQueue<Job> q = new PriorityQueue<Job>();
			for (int j = 0; j < count; j++) {
				q.add(new Job(scnr.nextLong(), scnr.nextLong(), scnr.nextLong()));
				scnr.nextLine();
			}
			long[] solution = new long[count + 1];
			long[] ledgew = new long[count + 1];
			solution[0] = 0;
			ledgew[0] = 0;
			for (int j = 1; j <= count; j++) {
				Job temp = q.poll();
				long ts = 0;
				//long tw = 0;
				for (int k = 0; k < j; k++) {
					if (temp.start >= ledgew[k]) {
						if (solution[k] + temp.weight > ts) {
							ts = solution[k] + temp.weight;
							//tw = ledgew[k];
						}
					}
				}
				if (ts > solution[j - 1]) {
					ledgew[j] = temp.end;
					solution[j] = ts;
				}
				else {
					ledgew[j] = ledgew[j - 1];
					solution[j] = solution[j - 1];
				}
			}
			
			System.out.println(solution[count]);
		}
		scnr.close();
	}
}


class Job implements Comparable<Job>{
	public long start;
	public long end;
	public long weight;
	
	public Job(long start, long end, long weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Job o) {
		if (o.end < this.end) {
			return 1;
		}
		else if (o.end > this.end) {
			return -1;
		}
		return 0;
	}
	
}