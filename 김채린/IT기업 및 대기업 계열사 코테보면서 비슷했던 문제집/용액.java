import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nums = Integer.parseInt(br.readLine());
		int[] arr =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int l = 0;
		int r = nums - 1;
		int[] result = new int[2];
		int min = Integer.MAX_VALUE;
		while (l < r) {
			int sum = arr[l] + arr[r];
			if(Math.abs(sum)<min){
				result[0] = arr[l];
				result[1] = arr[r];
				if (sum==0){
					break;
				}
				min = Math.abs(sum);
			}
			if (sum < 0) {
				l++;
			} else {
				r--;
			}
		}
		System.out.println(result[0] + " " + result[1]);
	}
}
