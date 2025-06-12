import java.io.*;
import java.util.*;

public class Main {
	static String[][] arr;
	static int[] heart = new int[] {-1, -1};
	static int[] dx = new int[] {-1, 1, 0};
	static int[] dy = new int[] {0, 0, 1};
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new String[n][n];
		for(int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).filter(it -> it != " ").toArray(it-> new String[it]);
			if(heart[0]==-1){
				for(int j = 0; j < n; j++) {
					if (arr[i][j].equals("*")){
						heart[0] = i+1;
						heart[1] = j;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(heart[0]+1+" "+(int)(heart[1]+1)+"\n");
		for (int i=0; i<3; i++){
			if (i==2){
				int nn = get(i, heart[1], heart[0]);
				sb.append(nn + " ");
				int newY = heart[0] + nn;
				sb.append(get(i, heart[1]-1, newY) + " ");
				sb.append(get(i, heart[1]+1, newY));
			}else {
				sb.append(get(i, heart[1], heart[0]) + " ");
			}
		}

		System.out.println(sb.toString().trim());
	}

	public static int get(int distance, int x, int y) {
		int newX = x + dx[distance];
		int newY = y + dy[distance];
		int count = 0;
		while (newX>-1&&newX<n&& newY>-1&& newY<n&&arr[newY][newX].equals("*")){
			count++;
			newX += dx[distance];
			newY += dy[distance];
		}
		return count;
	}
}
