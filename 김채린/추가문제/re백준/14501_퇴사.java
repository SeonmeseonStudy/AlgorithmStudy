import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[] result;
	static int max=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1][2];
		result = new int[N+2];
		for (int i=1; i<N+1; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			result[i] =  Math.max(result[i], result[i-1]);
			if (i+arr[i][0] <= N+1) {
				result[i+arr[i][0]] = Math.max(result[i+arr[i][0]], result[i] + arr[i][1]);
				max = Math.max(max, result[i+arr[i][0]]);
			}
		}
		System.out.println(max);
	}
}
