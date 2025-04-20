import java.io.*;
import java.util.*;

class Main{
	static int n;
	static int[] nums;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sol(1,arr,nums[0]);
		System.out.println(max);
		System.out.println(min);
	}

	public static void sol(int index, int[] visited,int before){
		if(index>=n){
			max = Math.max(before, max);
			min = Math.min(before,min);
			return;
		}
		for(int i =0; i<4; i++){
			if (visited[i]>0){
				visited[i]--;
				int result = 0;
				switch (i){
					case 0:
						result = before + nums[index];
						break;
					case 1:
						result = before - nums[index];
						break;
					case 2:
						result = before * nums[index];
						break;
					case 3:
						result = before / nums[index];
						break;
				}
				sol(index+1,visited,result);
				visited[i]++;
			}
		}
	}
}
