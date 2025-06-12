import java.io.*;
import java.util.*;

public class Main {
	static String[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new String[n];
		HashMap<Character, Integer> map = new HashMap<>();
		char[] chars = br.readLine().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			map.put(chars[i], map.getOrDefault(chars[i],0)+1);
		}
		int result = 0;
		for (int i=0; i<n-1; i++){
			String now = br.readLine();
			char[] inputChars = now.toCharArray();
			HashMap<Character, Integer> inputMap = new HashMap<>(map);
			int count = 0;
			for (int j = 0; j < inputChars.length; j++) {
				if (inputMap.containsKey(inputChars[j]) && inputMap.get(inputChars[j]) > 0) {
					inputMap.put(inputChars[j], inputMap.get(inputChars[j]) - 1);
				} else {
					count++;
				}
				if (count>1){
					break;
				}
			}
			if (inputChars.length != chars.length) {
				for (char key : inputMap.keySet()) {
					if (inputMap.get(key) != 0) {
						count+= inputMap.get(key);
						if (count > 1) {
							break;
						}
					}
				}
			}
			if (count <= 1) {
				result++;
			}
		}
		System.out.println(result);
	}
}
