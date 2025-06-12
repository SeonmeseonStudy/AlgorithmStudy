import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i<n[0]; i++){
			String s = br.readLine();
			if (s.length()>=n[1]){
				map.put(s, map.getOrDefault(s,0)+1);
			}
		}
		StringBuilder sb = new StringBuilder();
		sort(map).forEach(it-> sb.append(it).append("\n"));
		System.out.print(sb);
	}

	public static List<String> sort(Map<String, Integer> map) {
		List<String> list = new ArrayList<>(map.keySet());
		list.sort((a,b) -> {
			if (map.get(a).equals(map.get(b))){
				if (a.length()==b.length()){
					return a.compareTo(b);
				}else{
					return b.length()-a.length();
				}
			}else {
				return map.get(b)-map.get(a);
			}
		});
		return list;
	}
}
