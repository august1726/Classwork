import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.HashMap;

public class DepthFirstSearch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inst = Integer.parseInt(scan.nextLine().trim()); // number of instances
		for (int i = 0; i < inst; i++) {
			int numNodes = Integer.parseInt(scan.nextLine().trim()); // nodes per instance
			Stack<String> stack = new Stack<String>();
			LinkedList<String> priority = new LinkedList<String>();
			// hashtable/hashmap to store nodes with adjacent nodes
			HashMap<String, LinkedList<String>> graph = new HashMap<String, LinkedList<String>>();
			for (int j = 0; j < numNodes; j++) {
				// scanner nextline
				// first char added to hashtable with next ones as keys
				// in order, add chars to priority if not already in priority
				// when done, pop char off priority into stack
				// pop off stack, get adjacent nodes and add to stack in priorty order
				String[] line = scan.nextLine().trim().split(" ");
				if (!priority.contains(line[0])) {
					priority.add(line[0]);
				}
				graph.put(line[0], new LinkedList<String>());
				for (int k = 1; k < line.length; k++) {
					graph.get(line[0]).add(line[k]);
					if (!priority.contains(line[k])) {
						priority.add(line[k]);
					}
				}
			}
			//stack.clear();
			stack.push(priority.peek());
			while (!priority.isEmpty()) {
				if (!stack.isEmpty()) {
					String current = stack.pop();
					System.out.print(current);
					if (priority.size() > 1) {
						System.out.print(" ");
					}
					priority.remove(priority.indexOf(current));
					if (graph.get(current) != null) {
						for (int k = graph.get(current).size() - 1; k >= 0; k--) {
							if (priority.contains(graph.get(current).get(k))) {
								if (stack.contains(graph.get(current).get(k))) {
									stack.remove(stack.indexOf(graph.get(current).get(k)));
								}
								stack.push(graph.get(current).get(k));
							}
						}
					}
				} else {
					stack.add(priority.peek());
				}
			}
			//if (i < inst - 1) {
			System.out.print("\n");
			//}
		}
		scan.close();
	}

}
