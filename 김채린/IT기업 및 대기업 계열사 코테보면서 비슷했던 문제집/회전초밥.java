import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(nums[3], 1);
		int[] arr = new int[nums[0]];
		for (int i = 0; i < nums[0]; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int index = 0;
		int max = 0;
		while (index < nums[0]) {
			if (index == 0) {
				for (int i = 0; i < nums[2]; i++) {
					map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
				}
			} else {
				int plusIndex = (index + nums[2] -1) % nums[0];
				map.put(arr[plusIndex], map.getOrDefault(arr[plusIndex], 0) + 1);
			}
			max = Math.max(max,map.size());
			int now = map.get(arr[index]);
			if (now <= 1) {
				map.remove(arr[index]);
			} else {
				map.put(arr[index], now - 1);
			}
			index++;
		}
		System.out.println(max);
	}
}
