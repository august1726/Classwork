import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxFlow {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int inst = Integer.parseInt(scnr.nextLine());
		for (int i = 0; i < inst; i++) {
			int nodes = scnr.nextInt();
			int edges = scnr.nextInt();
			scnr.nextLine();
			int[][] adj = new int[nodes][nodes];
			HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
			for (int j = 0; j < edges; j++) {
				int s = scnr.nextInt();
				int e = scnr.nextInt();
				int c = scnr.nextInt();
				if (!graph.containsKey(s)) {
					graph.put(s, new ArrayList<Integer>());
				}
				if (adj[s][e] > 0) {
					graph.get(s).add(e);
				}
				adj[s][e] += c;
				
			}
			scnr.nextLine();
			
			
			while (true) {
				LinkedList<Integer> q = new LinkedList<Integer>();
				ArrayList<Integer> visited = new ArrayList<Integer>();
				
				for (int u : graph.get(1)) {
					q.push(u);
				}
				
			}
		
		}
		scnr.close();
	}
	
}
