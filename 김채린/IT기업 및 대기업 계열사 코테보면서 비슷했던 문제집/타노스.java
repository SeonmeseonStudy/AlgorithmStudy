import java.io.*;
import java.util.*;

public class Main {
	static String[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] n = br.readLine().toCharArray();
		int zeroCount = 0;
		for (int i = 0; i < n.length; i++) {
			if (n[i] == '0') {
				zeroCount++;
			}
		}
		int oneCount = n.length - zeroCount;
		zeroCount/=2;
		int oneCount2 = oneCount/2;
		for (int i = 0; i < n.length; i++) {
			if (n[i] == '0') {
				if (zeroCount >= 1) {
					System.out.print("0");
					zeroCount--;
				}
			} else {
				if (oneCount>oneCount2){
					oneCount--;
				}else{
					System.out.print("1");
				}
			}
		}
	}
}
