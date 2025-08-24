import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Map<String, Integer> map = new HashMap<>();
		for (int i=0; i<n[0]; i++){
			map.put(br.readLine(), 1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n[1];  i++){
			String[] now = br.readLine().split(",");
			for(String s : now){
				map.remove(s);
			}
			sb.append(map.size()).append("\n");
		}
		System.out.println(sb.toString());
	}
}
