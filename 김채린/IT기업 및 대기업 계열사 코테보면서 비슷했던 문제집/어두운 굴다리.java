import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int max= Math.max(arr[0],n-arr[n2 - 1]);
		int mid = 0;
		for (int i = 0; i < n2-1; i++) {
			int a = arr[i+1]-arr[i];
			if (mid<a){
				mid = a;
			}
		}
		if (mid!=0&&(mid/2+mid%2)>max){
			max = mid/2+mid%2;
		}
		System.out.println(max);
	}
}
