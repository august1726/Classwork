import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
//import java.lang.Comparable;

public class FordFulkerson {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int inst = Integer.parseInt(scnr.nextLine());
		for (int i = 0; i < inst; i++) {
			int nodes = scnr.nextInt();
			int edges = scnr.nextInt();
			scnr.nextLine();
			LinkedList<Edge> q = new LinkedList<Edge>();
			HashMap<Integer, PriorityQueue<Edge>> graph = new HashMap<Integer, PriorityQueue<Edge>>();
			for (int j = 0; j < edges; j++) {
				int s = scnr.nextInt();
				int e = scnr.nextInt();
				int c = scnr.nextInt();
				if (!graph.containsKey(s)) {
					graph.put(s, new PriorityQueue<Edge>());
				}
				//if (graph.get(s).con)
				graph.get(s).add(new Edge(s, e, c));
				//q.add(new Edge(scnr.nextInt(), scnr.nextInt(), scnr.nextInt()));
			}
			scnr.nextLine();
			long delta = (long)Math.pow(2, graph.get(1).peek().cap);
			for (Edge e : graph.get(1)) {
				q.push(e);
			}
			while (delta >= 1) {
				if (q.isEmpty()) {
					
				}
				Edge e = q.pop();
				
				delta /= 2;
			}
		}
		scnr.close();
	}
	
}

class Edge implements Comparable<Edge> {
	public int start;
	public int end;
	public int cap;
	
	public Edge(int start, int end, int cap) {
		this.start = start;
		this.end = end;
		this.cap = cap;
	}
	
	@Override
	public int compareTo(Edge a) {
		if (this.cap > a.cap) {
			return 1;
		}
		if (this.cap < a.cap) {
			return -1;
		}
		return 0;
	}
	
}