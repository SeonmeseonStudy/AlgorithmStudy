import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> a.compareTo(b));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++){
			int now =Integer.parseInt(br.readLine());
			if (now==0){
				if (q.isEmpty()){
					sb.append(0).append("\n");
				}else{
					sb.append(q.poll()).append("\n");
				}
				continue;
			}
			q.add(now);
		}
		System.out.print(sb);
	}
}
