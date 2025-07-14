import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] arr = new int[num[0]][3];
		for(int i=0; i<num[0]; i++){
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		Arrays.sort(arr, (a,b)->{
			if (a[0]==b[0]){
				if (a[1]==b[1]){
					return a[2]-b[2];
				}else {
					return a[1]-b[1];
				}
			}else {
				return a[0]-b[0];
			}});
		int[] result = new int[num[1]+1];
		for (int i = 1; i <= num[1]; i++) {
			result[i] = Math.min(result[i-1]+1, i);
			for (int j = 0; j < num[0]; j++) {
				if (arr[j][1]==i){
					result[i] = Math.min(result[i], result[arr[j][0]] + arr[j][2]);
				}
			}
		}
		System.out.println(result[num[1]]);
	}
}
