import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		int[] result = new int[num];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < num; i++) {
			int index = i;
			while (index > 0) {
				if (arr[index - 1] >= arr[i]) {
					result[i] = index;
					break;
				}
				index = result[index - 1];
			}
		}
		for (int i = 0; i < num; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}
