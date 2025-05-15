import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Y",1);
		map.put("F",2);
		map.put("O",3);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		HashSet<String> list = new HashSet<>();
		int member = map.getOrDefault(arr[1], -1);
		int num = Integer.parseInt(arr[0]);
		for(int i=0; i<num; i++){
			String now = br.readLine();
			if (list.contains(now)){
				continue;
			}
			list.add(now);
		}
		System.out.println(list.size()/member);
	}
}
