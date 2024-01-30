import java.util.Scanner;

public class BM {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int inst = Integer.parseInt(scnr.nextLine());
		for (int instances = 0; instances < inst; instances++) {
			int m = scnr.nextInt();
			int n = scnr.nextInt();
			int q = scnr.nextInt();
			boolean[][] bip = new boolean[m][n];
			for (int i = 0; i < q; i++) {
				int i1 = scnr.nextInt();
				int j1 = scnr.nextInt();
				bip[i1-1][j1-1] = true;
			}
			int max = maxBM(bip);
			if (max < Math.max(m, n)) {
				System.out.println(max + " N");
			}
			else {
				System.out.println(max + " Y");
			}
		}
		scnr.close();
	}
	
	public static int maxBM(boolean[][] bip) {
		int m = bip.length;
		int n = bip[0].length;
		int jobs[] = new int[n];
		for(int i = 0; i < n; i++) {
			jobs[i] = -1;
		}
		int result = 0; 
		for (int i = 0; i < m; i++) {
			boolean seen[] = new boolean[n] ;
			if (bipMatch(bip, i, seen, jobs)) {
				result++;
            }
        }
        return result;
	}
	
	static boolean bipMatch(boolean bip[][], int i, boolean seen[], int jobs[]) {
		for (int j = 0; j < bip[0].length; j++) {
			if (bip[i][j] && !seen[j]) {
				seen[j] = true;
				if (jobs[j] < 0 || bipMatch(bip, jobs[j], seen, jobs)) {
					jobs[j] = i;
					return true;
				}
			}
		}
		return false;
	}
}
