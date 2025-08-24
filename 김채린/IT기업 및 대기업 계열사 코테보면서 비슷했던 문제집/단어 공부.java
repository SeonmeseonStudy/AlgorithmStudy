import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toUpperCase().toCharArray();
		int[] arr = new int[26];
		for (int i=0; i<s.length; i++){
			arr[s[i]-'A']++;
		}
		int max =0;
		char result =0;
		boolean oneMax = true;
		for (int i=0; i< arr.length; i++){
			if (max<arr[i]){
				oneMax = true;
				max = arr[i];
				result = (char)('A'+i);
			}else if (max==arr[i]){
				oneMax = false;
			}
		}
		if (oneMax){
			System.out.println(result);
		}else {
			System.out.println("?");
		}
	}
}
