import java.util.*;
import java.io.*;
class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		int[] visited = new int[101];
		Arrays.fill(visited, -1);
		for (int i = 0; i < num[0]; i++) {
			int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			map.put(now[0], now[1]);
		}
		for (int i = 0; i < num[1]; i++) {
			int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			map.put(now[0], now[1]);
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{1,0});
		visited[1] = 0;
		while (!queue.isEmpty()){
			int[] now = queue.poll();
			for(int i=1; i<=6; i++){
				int next = now[0]+i;
				if (next >= 100){
					System.out.print(now[1]+1);
					return;
				}
				next = map.getOrDefault(next, next);
				next = map2.getOrDefault(next, next);
				if (visited[next]==-1) {
					queue.add(new int[] {next, now[1] + 1});
					visited[next] = now[1] + 1;
				}
			}
		}
	}
}
