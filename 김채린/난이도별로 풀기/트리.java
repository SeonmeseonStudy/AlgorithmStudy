import java.util.*;
import java.io.*;
class Main {
	static int max = 0;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		boolean[] delete = new boolean[num];
		boolean[] noleaf = new boolean[num];
		int n = Integer.parseInt(br.readLine());
		delete[n] = true;
		noleaf[n] = true;
		for (int i = 0; i < num; i++) {
			if (i == n) {
				continue;
			}
			if (arr[i] != -1) {
				if (!delete[arr[i]]) {
					noleaf[arr[i]] = true;
				} else {
					delete[i] = true;
					noleaf[i] = true;
				}
			}
		}
		for (int i = 0; i < num; i++) {
			if (!noleaf[i]) {
				max++;
			}
		}
		System.out.println(max);
	}
}
