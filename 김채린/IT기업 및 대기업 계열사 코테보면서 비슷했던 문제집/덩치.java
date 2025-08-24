import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		int[][] input = new int[n][2];
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j=0; j<i; j++){
				if (input[i][0]>input[j][0]&& input[i][1]>input[j][1]){
					result[j]++;
				}else if (input[i][0]<input[j][0]&& input[i][1]<input[j][1]){
					result[i]++;
				}
			}
		}
		for(int i:result){
			System.out.print((i+1)+" ");
		}
	}
}
