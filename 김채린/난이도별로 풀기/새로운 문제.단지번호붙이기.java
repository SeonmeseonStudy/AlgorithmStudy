import java.util.*;
import java.io.*;
import java.math.*;
/*7
0110100
0110101
1110101
0000111
0100000
0111110
0111000*/
class Main {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int n = 0;
	static int[][] maps = new int[0][0];
	static boolean[][] visited = new boolean[0][0];
	static int apt = 0;
	static int count =1;
	static List<Integer> result = new ArrayList<>();
	public static void solution(int x, int y){
		for (int i=0; i<4; i++){
			int newX = dx[i]+x;
			int newY = dy[i]+y;
			if (newX>=0&&newY>=0&&newX<n&&newY<n&&!visited[newY][newX]&&maps[newY][newX]==1){
				count++;
				visited[newY][newX]=true;
				solution(newX,newY);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maps = new int[n][n];
		for (int i = 0; i < n; i++) {
			maps[i] = Arrays.stream(br.readLine().split("")).filter(it -> !it.equals(""))
				.mapToInt(Integer::parseInt).toArray();
		}
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && maps[i][j] == 1) {
					visited[i][j] = true;
					apt++;
					solution(j, i);
					int num = count;
					result.add(num);
					count = 1;
				}
			}
		}
		result.sort(Comparator.naturalOrder());
		System.out.println(apt);
		for (int i = 0; i < apt; i++) {
			System.out.println(result.get(i));
		}
	}
}
