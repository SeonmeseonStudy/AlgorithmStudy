import java.util.*;
import java.io.*;
import java.math.*;
class Main {
	static int[][] arr;
	static int n;
	static int half;
	static int min = Integer.MAX_VALUE;
	static int total =0;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		half=n/2;
		arr = new int[n][n];
		for (int i=0; i<n; i++){
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j=0; j<n; j++) {
				total+=arr[i][j];
			}
		}
		ArrayList<Integer> select = new ArrayList<>();
		sol(0,0,0,select);
		System.out.println(min);
	}

	public static void sol(int now,int count, int result, ArrayList<Integer> select){
		if (count==half){
			int result2 =0;
			ArrayList<Integer> select2 = new ArrayList<>();
			for (int i=0; i<n; i++){
				if (select.contains(i)){
					continue;
				}
				select2.add(i);
			}
			for (int i=0; i<half-1; i++){
				int a = select2.get(i);
				for (int j=i+1; j<half; j++){
					result2+=(arr[a][select2.get(j)]+arr[select2.get(j)][a]);
				}
			}
			min = Math.min(Math.abs(result-result2), min);
			return;
		}
		for (int i =now; i<n;i++){
			int newResult = result;
			select.add(i);
			for (int j=0; j<count; j++){
				newResult+=(arr[i][select.get(j)]+arr[select.get(j)][i]);
			}
			sol(i+1,count+1,newResult,select);
			select.remove(count);
		}
	}
}
