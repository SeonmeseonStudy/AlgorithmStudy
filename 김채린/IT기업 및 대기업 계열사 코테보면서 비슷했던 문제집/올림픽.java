import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int index = 0;
		int[][] input = new int[n[0]][4];
		for (int i = 0; i < n[0]; i++) {
			input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if (input[i][0] == n[1]) {
				index = i;
			}
		}
		int result = 1;
		for (int j = 0; j < n[0]; j++) {
			if (index == j) {
				continue;
			}
			for (int i = 1; i <= 3; i++) {
				if (input[j][i] > input[index][i]) {
					result++;
					break;
				} else if (input[j][i] < input[index][i]) {
					break;
				}
			}
		}
		System.out.println(result);
	}
}
