import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder original = new StringBuilder();
		original.append(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int curser = original.length();
		for (int i = 0; i < n; i++) {
			String[] now = br.readLine().split(" ");
			if (now[0].equals("L")){
				if (curser>0){
					curser--;
				}
			}else if (now[0].equals("D")){
				if (curser<original.length()){
					curser++;
				}
			}else if (now[0].equals("B")){
				if (curser>0){
					original.deleteCharAt(curser-1);
					curser--;
				}
			}else {
				original.insert(curser, now[1]);
				curser++;
			}
		}
		System.out.println(original.toString());
	}
}
