import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] =sc.nextInt();
		}
		int start = 0;
		int end = 1;
		int count =1;
		int total = arr[0];
		int max = 0;
		int result = 1;
		while (end<n){
			if (count<x){
				total+=arr[end];
				end++;
				count++;
			}else if (count==x){
				if (max==total){
					result++;
				}else if (max<total){
					max = total;
					result = 1;
				}
				total -= arr[start];
				count--;
				start++;
			}
		}
		if (max==total){
			result++;
		}else if (max<total){
			max = total;
			result = 1;
		}


		if (max==0){
			System.out.println("SAD");
		}else{
			System.out.println(max);
			System.out.println(result);
		}
	}
}
