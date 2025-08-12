import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num+1];
		boolean[] visited = new boolean[num+1];
		boolean[] check = new boolean[num+1];
		ArrayList<Integer> resultList = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i==arr[i]){
				visited[i] = true;
				resultList.add(i);
			}
		}
		for (int i = 1; i <= num; i++) {
			if (visited[i]) {
				continue;
			}
			int now = i;
			ArrayList<Integer> list = new ArrayList<>();
			while (true) {
				if (visited[now]) {
					break;
				}
				if (check[now]) {
					int idx = list.indexOf(now); // 사이클 시작 인덱스 찾기
					for (int k = idx; k < list.size(); k++) {
						resultList.add(list.get(k));
					}
					break;
				}
				list.add(now);
				check[now] = true;
				now = arr[now];
			}
			for (int a : list) {
				visited[a] = true;
				check[a] = false;
			}
		}
		System.out.println(resultList.size());
		resultList.sort((a,b)-> a-b);
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}
}
