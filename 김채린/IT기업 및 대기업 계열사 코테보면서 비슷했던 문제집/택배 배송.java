import java.util.*;
import java.io.*;
class Main {
	static int[] nums;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nums = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
		for (int i = 0; i < nums[1]; i++) {
			int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
				.toArray();
			ArrayList<int[]> list = map.getOrDefault(now[0]-1,new ArrayList<int[]>());
			list.add(new int[]{now[1]-1,now[2]});
			map.put(now[0]-1,list);
			ArrayList<int[]> list2 = map.getOrDefault(now[1]-1,new ArrayList<int[]>());
			list2.add(new int[]{now[0]-1,now[2]});
			map.put(now[1]-1,list2);
		}
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		q.add(new int[] {0, 0});
		int[] visited = new int[nums[0]];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[0] = 0;
		while (!q.isEmpty()) {
			int[] nowNum = q.poll();
			if (nowNum[0] == nums[0] - 1) {
				System.out.println(nowNum[1]);
				return;
			}
			ArrayList<int[]> arr = map.get(nowNum[0]);
			for (int i = 0; i < arr.size(); i++) {
				int nextCost = nowNum[1] + arr.get(i)[1];
				if (visited[arr.get(i)[0]] <= nextCost) continue;
				visited[arr.get(i)[0]] = nextCost;
				q.add(new int[] {arr.get(i)[0], nextCost});
			}
		}
	}
}
