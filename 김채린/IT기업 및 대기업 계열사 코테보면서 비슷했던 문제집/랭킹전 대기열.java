import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<PriorityQueue<String[]>> queues = new ArrayList<>();
		List<Integer> levels = new ArrayList<>();
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n[0]; i++){
			String[] now = br.readLine().split(" ");
			if (queues.isEmpty()){
				PriorityQueue<String[]> queue = new PriorityQueue<>((a, b) -> a[1].compareTo(b[1]));
				queue.add(now);
				queues.add(queue);
				levels.add(Integer.parseInt(now[0]));
				continue;
			}
			boolean found = false;
			int nowNum = Integer.parseInt(now[0]);
			for(int j=0; j<levels.size(); j++){
				if (queues.get(j).size()<n[1]&&nowNum>=levels.get(j)-10&& nowNum<=levels.get(j)+10){
					found = true;
					PriorityQueue<String[]> queue = queues.get(j);
					queue.add(now);
					break;
				}
			}
			if (!found){
				PriorityQueue<String[]> queue = new PriorityQueue<>((a, b) -> a[1].compareTo(b[1]));
				queue.add(now);
				queues.add(queue);
				levels.add(Integer.parseInt(now[0]));
			}
		}
		for (int i=0; i<queues.size(); i++){
			PriorityQueue<String[]> queue = queues.get(i);
			if (queue.size()==n[1]){
				sb.append("Started!").append("\n");
			}else {
				sb.append("Waiting!").append("\n");
			}
			while (!queue.isEmpty()){
				String[] now = queue.poll();
				sb.append(now[0]).append(" ").append(now[1]).append("\n");
			}
		}
		System.out.print(sb);
	}
}
