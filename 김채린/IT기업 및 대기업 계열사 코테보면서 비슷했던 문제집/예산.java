import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int total = 0;
		int max =-1;
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
			total+=arr[i];
			if (arr[i]>max){
				max = arr[i];
			}
		}
		int money = sc.nextInt();
		if (total<=money){
			System.out.println(max);
		}else{
			int result = money/n;
			int cost = money%n;
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (arr[i] > result) {
					list.add(i);
				} else {
					cost+= (result - arr[i]);
				}
			}
			while (cost>=list.size()){
				result += cost/list.size();
				cost = cost%list.size();
				for (int i = 0; i < list.size(); i++) {
					if (arr[list.get(i)] <= result) {
						cost += (result - arr[list.get(i)]);
						list.remove(i);
						i--;
					}
				}
			}
			System.out.println(result);
		}
	}
}
