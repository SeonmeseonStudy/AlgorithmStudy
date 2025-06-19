import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		for (int i = 0; i < n; i++) {
			int now =Integer.parseInt(br.readLine());
			long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			long max = arr[now - 1];
			long total = 0;
			for (int j=now-2; j>=0; j--){
				if (arr[j]<max){
					total+= max-arr[j];
				} else if (arr[j]>max) {
					max = arr[j];
				}
			}
			System.out.println(total);
		}
	}
}
