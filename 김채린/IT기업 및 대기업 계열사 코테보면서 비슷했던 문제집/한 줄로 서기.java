import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] result = new int[n];
		for(int i=0; i<n; i++){
			int index = 0;
			int count = arr[i];
			while(true){
				if (count==0){
					if (result[index]==0) {
						result[index] = i + 1;
						break;
					}
				}else if (result[index]==0){
					count--;
				}
				index++;
			}
		}

		for (int i:result){
			System.out.print(i + " ");
		}
	}
}
