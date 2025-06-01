import java.io.*;
import java.util.Arrays;

public class Main {
	static char[] aeiou = {'a', 'e', 'i', 'o', 'u'};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		if (arr[0] == 0) {
			System.out.println(1);
			return;
		}
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int count = 1;
		for (int i = 0; i < arr[0]; i++) {
			if (input[i] <= arr[1]) {
				if (input[i] == arr[1]) {
					int pius = 0;
					while (i < arr[0] && input[i] == arr[1]) {
						pius++;
						i++;
						if (pius + count > arr[2]) {
							System.out.println(-1);
							return;
						}
					}
				}
				break;
			}
			count++;
			if (count > arr[2]) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(count);
	}
}
