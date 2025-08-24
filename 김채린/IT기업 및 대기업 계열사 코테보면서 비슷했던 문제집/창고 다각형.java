import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1002];
		int start = 1000;
		int end = 0;
		int[] max = new int[2];
		for (int i = 0; i < n; i++) {
			int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if (now[0]< start) {
				start = now[0];
			}
			if (now[0]> end) {
				end = now[0];
			}
			if (now[1]>max[1]){
				max[0] = now[0];
				max[1] = now[1];
			}
			arr[now[0]] = now[1];
		}
		int total = max[1];
		int nowIndex = start;
		for (int i = start+1; i <= max[0]; i++) {
			if (arr[nowIndex]<=arr[i]){
				total += (i-nowIndex) * arr[nowIndex];
				nowIndex = i;
			}
		}

		nowIndex = end+1;
		for (int i = end; i>=max[0]; i--) {
			if (arr[nowIndex]<=arr[i]){
				total += (nowIndex-i) * arr[nowIndex];
				nowIndex = i;
			}
		}
		System.out.print(total);
	}
}
