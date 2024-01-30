import java.util.Scanner;
public class HelloWorld {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lines = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < lines; i++) {
			System.out.print("Hello, ");
			System.out.print(scan.nextLine().trim());
			System.out.println("!");
		}
		scan.close();
	}
}
