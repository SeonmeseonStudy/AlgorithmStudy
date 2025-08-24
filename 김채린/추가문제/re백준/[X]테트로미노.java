import java.io.*;
import java.util.*;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[][] visited;
	static int n;
	static int m;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		visited = new boolean[n][m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visited[i][j] = true;
				sol(i,j,arr[i][j],1);
				visited[i][j] = false;
			}
		}

		System.out.println(max);
	}

	static void sol(int row, int col, int sum, int count) {
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}

		for(int i = 0; i < 4; i++) {
			int curRow = row + dx[i];
			int curCol = col + dy[i];

			if(curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
				continue;
			}

			if(!visited[curRow][curCol]) {
				// 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
				if(count == 2) {
					visited[curRow][curCol] = true;
					sol(row, col, sum + arr[curRow][curCol], count + 1);
					visited[curRow][curCol] = false;
				}

				visited[curRow][curCol] = true;
				sol(curRow, curCol, sum + arr[curRow][curCol], count + 1);
				visited[curRow][curCol] = false;
			}
		}
	}
}
