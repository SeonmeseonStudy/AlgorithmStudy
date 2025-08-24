import java.util.*;
import java.io.*;
class Main {
	static int min = Integer.MAX_VALUE;
	static int[] answer = new int[2];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		int left = 0;
		int right = num-1;
		while (left<right){
			int sum = arr[left] + arr[right];
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				answer[0] = arr[left];
				answer[1] = arr[right];
			}
			if (sum==0) {
				break;
			}else if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
	}
}
