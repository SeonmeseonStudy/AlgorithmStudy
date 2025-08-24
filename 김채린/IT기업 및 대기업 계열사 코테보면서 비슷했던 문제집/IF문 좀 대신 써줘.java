import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		List<String> stringList = new ArrayList<>();
		List<Integer> integerList = new ArrayList<>();
		for (int i = 0; i < n[0]; i++) {
			String[] input = br.readLine().split(" ");
			stringList.add(input[0]);
			integerList.add(Integer.parseInt(input[1]));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n[1]; i++) {
			int now = Integer.parseInt(br.readLine());
			sb.append(sol(stringList, integerList, now)).append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}

	public static String sol(List<String> stringList, List<Integer> integerList, int now) {
		int left = 0;
		int right = stringList.size() - 1;
		int midIndex = 0;
		while (left<right){
			midIndex = (left + right) / 2;
			int mid = integerList.get(midIndex);
			if (now<=mid){
				right = midIndex;
			}else {
				left = midIndex + 1;
			}
		}
		return stringList.get((left+right)/2);
	}
}
