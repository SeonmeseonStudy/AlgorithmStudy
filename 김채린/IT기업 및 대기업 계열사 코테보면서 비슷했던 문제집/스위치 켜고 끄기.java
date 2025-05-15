import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if (input[0]==1){
				int index = input[1]-1;
				while (index<n){
					arr[index]= (arr[index]+1)%2;
					index+=input[1];
				}
			}else {
				arr[input[1]-1]= (arr[input[1]-1]+1)%2;
				int start = input[1]-2;
				int end = input[1];
				while (end<n &&start>-1){
					if (arr[start]==arr[end]){
						arr[start]= (arr[start]+1)%2;
						arr[end]= (arr[end]+1)%2;
						start--;
						end++;
					}else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (i%20==0&&i!=0){
				System.out.println();
			}
			System.out.print(arr[i]+" ");
		}
	}
}
