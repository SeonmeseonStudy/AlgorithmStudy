import java.util.*;
import java.io.*;
class Main {
	static int max = 0;
	static int[][] arr;
	static boolean[][] visited;
	static int size = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		arr = new int[num[0]][num[1]];
		visited = new boolean[num[0]][num[1]];
		for (int i = 0; i < num[0]; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		int count = 0;
		for (int i = 0; i < num[0]; i++) {
			for (int j = 0; j < num[1]; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					count++;
					size = 1;
					dfs(i, j);
					max = Math.max(max, size);
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}

	public static void dfs(int y, int x) {
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && ny < arr.length && nx >= 0 && nx < arr[0].length) {
				if (arr[ny][nx] == 1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					size++;
					dfs(ny, nx);
				}
			}
		}
	}
}
