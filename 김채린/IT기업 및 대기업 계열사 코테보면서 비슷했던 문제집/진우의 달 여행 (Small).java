import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int result = Integer.MAX_VALUE;
	static int[] dx = {1, 0, -1};
	static int[] dy = {1, 1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		arr = new int[n[0]][n[1]];
		for(int i = 0; i < n[0]; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for(int i=0; i<n[1]; i++){
			getRow(0,i, arr[0][i],-1);
		}
		System.out.println(result);
	}

	public static void getRow(int y, int x, int total, int before) {
		if (y == arr.length-1) {
			result = Math.min(result, total);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (before==i){
				continue;
			}
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && ny < arr.length && nx >= 0 && nx < arr[0].length) {
				getRow(ny, nx, total + arr[ny][nx],i);
			}
		}
	}
}
