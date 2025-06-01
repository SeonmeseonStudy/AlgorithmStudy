import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] distance = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		long[] oil = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		long nowOil = oil[0];
		long cost = nowOil* distance[0];
		for (int i = 1; i < n - 1; i++) {
			if (oil[i]<nowOil){
				nowOil = oil[i];
			}
			cost += nowOil * distance[i];
		}
		System.out.println(cost);
	}
}
