import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max= Integer.MIN_VALUE;
		for (int i = 0; i < k; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		long result = 0;
		long left = 1;
		long right = max;
		while (left<=right){
			long mid = (left+right)/2;
			long count = 0;
			for (int i = 0; i < k; i++) {
				count += arr[i]/mid;
			}
			if (count >= n){
				result = Math.max(result, mid);
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(result);
	}
}
