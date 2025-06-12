import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			sb.append(input[0]);
			int count = 0;
			for (int j = 2; j < input.length; j++) {
				for (int k=1; k<j; k++){
					if (input[j]<input[k]){
						count++;
					}
				}
			}
			sb.append(" ").append(count).append("\n");
		}
		System.out.print(sb);
	}
}
