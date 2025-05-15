import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++){
			int caseN = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Map<Integer, Integer> map = new HashMap<>();
			Map<Integer, Integer> five = new HashMap<>();
			int fiveCount = 0;
			for(int a: arr){
				int num= map.getOrDefault(a, 0)+1;
				if (num==5){
					five.put(a,fiveCount);
					fiveCount++;
				}
				map.put(a,num);
			}
			ArrayList<Integer> list = new ArrayList<>();
			for(int a :map.keySet()){
				if(map.get(a)==6){
					list.add(a);
					map.put(a, 0);
				}
			}
			int point =1;
			HashMap<Integer, Integer> four = new HashMap<>();
			for (int a:arr){
				if (list.contains(a)){
					if (four.getOrDefault(a,0)<4) {
						four.put(a, four.getOrDefault(a, 0) + 1);
						map.put(a, map.get(a) + point);
					}
					point++;
				}
			}
			int max = 0;
			for (int j=1; j<list.size(); j++){
				if (map.get(list.get(max))>map.get(list.get(j))){
					max = j;
				}else if(map.get(list.get(max)).equals(map.get(list.get(j)))){
					if (five.get(list.get(j))<five.get(list.get(max))){
						max = j;
					}
				}
			}
			System.out.println(list.get(max));
		}
	}
}
