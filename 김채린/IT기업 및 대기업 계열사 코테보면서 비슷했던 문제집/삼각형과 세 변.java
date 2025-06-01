import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int max = Math.max(a, Math.max(b, c));
			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			if (max * 2 >= a + b + c) {
				System.out.println("Invalid");
				continue;
			}
			if (a == b && b == c) {
				System.out.println("Equilateral");
			} else if (a == b || a == c || b == c) {
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
		}
	}
}
