import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		char[] inputChars = br.readLine().toCharArray();
		int count =0;
		for (int i=0; i<arr[0]; i++){
			if (inputChars[i]=='P'){
				int start = i-arr[1];
				int end = i+arr[1];
				if (start<0) start = 0;
				if (end>=arr[0]) end = arr[0]-1;
				for (int j=start; j<=end; j++){
					if (inputChars[j]=='H'){
						inputChars[j] = 'S';
						count++;
						break;
					}
				}
			}
		}
		System.out.println(count);
	}
}
