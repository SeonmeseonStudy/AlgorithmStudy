import java.io.*;
import java.util.*;

public class Main {
	static Stack<Long> s = new Stack<>();
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[26][m];
		for (int i = 0; i <= 25; i++) {
			arr[i][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 0; j <= 25; j++) {
				for (int k = 0; k <= 25; k++) {
					if (Math.abs(j - k) >= n) {
						arr[j][i] = (arr[j][i]+ arr[k][i - 1]) % 1000000007;
					}
				}
			}
		}
		int total = 0;
		for (int i = 0; i <= 25; i++) {
			total= (total+arr[i][m-1])% 1000000007;
		}
		System.out.println(total);
	}
}
