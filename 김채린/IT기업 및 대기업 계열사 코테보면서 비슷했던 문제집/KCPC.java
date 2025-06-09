import java.io.*;
import java.util.*;

public class Main {
	static String[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++){
			int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] last = new int[nums[0]];
			int[] counting = new int[nums[0]];
			int[][] score = new int[nums[0]][nums[1]];
			int target = nums[2]-1;
			for (int j=0; j<nums[3]; j++){
				int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				int teamNum = now[0]-1;
				score[teamNum][now[1]-1] = Math.max(score[teamNum][now[1]-1], now[2]);
				counting[teamNum]++;
				last[teamNum] = j+1;
			}
			int[] total = new int[nums[0]];
			for (int j=0; j<nums[0]; j++){
				for (int k=0; k<nums[1]; k++){
					total[j] += score[j][k];
				}
			}
			int result = 1;
			for (int j=0; j<nums[0]; j++){
				if (j==target){
					continue;
				} else {
					if (total[j] > total[target]) {
						result++;
					} else if (total[j] == total[target]) {
						if (counting[j] < counting[target]) {
							result++;
						}else if (counting[j] == counting[target]) {
							if (last[j] < last[target]) {
								result++;
							}
						}
					}
				}
			}
			System.out.println(result);
		}
	}
}
