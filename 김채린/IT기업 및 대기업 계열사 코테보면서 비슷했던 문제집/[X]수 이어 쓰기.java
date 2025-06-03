import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int i = 1;
		int result = (arr[0]-'0')+1;
		while (i < arr.length) {
			char[] now = String.valueOf(result).toCharArray();
			for (int j = 0; j < now.length; j++) {
				if (arr[i] == now[j]) {
					i++;
					if (i == arr.length) {
						System.out.println(result);
						return;
					}
				}
			}
			result++;
		}
	}
}
