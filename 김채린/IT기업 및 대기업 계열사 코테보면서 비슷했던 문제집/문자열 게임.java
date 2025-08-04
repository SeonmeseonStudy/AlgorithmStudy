import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			char[] arr = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			if (n == 1) {
				System.out.println("1 1");
				continue;
			}
			int S = Integer.MAX_VALUE;
			int L = Integer.MIN_VALUE;
			HashMap<Character, Integer> map = new HashMap<>();
			for (char c : arr) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			for (int j = 0; j < arr.length; j++) {
				if (map.get(arr[j]) >= n) {
					int count = 0;
					for (int k = j; k < arr.length; k++) {
						if (arr[k] == arr[j]) {
							count++;
						}
						if (count == n) {
							S = Math.min(S, k-j);
							L = Math.max(L, k-j);
							break;
						}
					}
				}
			}
			if (S == Integer.MAX_VALUE || L == Integer.MIN_VALUE) {
				System.out.println("-1");
			} else {
				System.out.println((S + 1) + " " + (L + 1));
			}
		}
	}
}
