import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		int answer = Integer.MAX_VALUE;
		HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
		for (int i = 0; i < num2; i++) {
			int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			ArrayList<int[]> list = map.getOrDefault(now[0], new ArrayList<>());
			list.add(new int[]{now[1], now[2]});
			map.put(now[0], list);
		}
		int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] result = new int[2]; // 지금 위치, 현재 비용
		int[] minArr = new int[num + 1];
		Arrays.fill(minArr, Integer.MAX_VALUE);
		minArr[target[0]] = 0;
		result[0] = target[0];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return a[1]-b[1];
		});
		pq.add(result);
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (now[1]>minArr[now[0]]|| now[1]>=answer){
				continue;
			}
			ArrayList<int[]> canGO = map.getOrDefault(now[0], new ArrayList<>());
			for(int[] next : canGO) {
				int nextCost = now[1]+ next[1];
				if (minArr[next[0]]>nextCost){
					minArr[next[0]] = nextCost;
					if (next[0] == target[1]) {
						answer = Math.min(answer, nextCost);
					} else {
						pq.add(new int[]{next[0], nextCost});
					}
				}
			}
		}
		System.out.println(answer);
	}
}
