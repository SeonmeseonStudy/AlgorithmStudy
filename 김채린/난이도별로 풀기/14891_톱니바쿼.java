import java.util.*;
import java.io.*;
class Main {
	static int[][] arr = new int[5][8];
	static int[] index12 = new int[5];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1; i <= 4; i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).filter(it-> !it.isEmpty()).mapToInt(Integer::parseInt).toArray();
		}
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			leftSol(nums[0], nums[1]);
			rightSol(nums[0], nums[1]);
			rotate(nums[0], nums[1]);
		}
		total();
	}

	public static void leftSol(int index, int dir){
		if (index>1){
			if (arr[index][(index12[index]+6)%8] != arr[index-1][(index12[index-1]+2)%8]){
				leftSol(index-1, -dir);
				rotate(index-1, -dir);
			}
		}
	}

	private static void rightSol(int index, int dir) {
		if (index<4){
			if (arr[index][(index12[index]+2)%8] != arr[index+1][(index12[index+1]+6)%8]){
				rightSol(index+1, -dir);
				rotate(index+1, -dir);
			}
		}
	}

	private static void rotate(int index, int dir) {
		if (dir==-1){
			index12[index]= (index12[index]+1)%8;
		}else {
			index12[index] = (index12[index]+7)%8;
		}
	}

	private static void total(){
		int total = 0;
		for (int i=1; i <= 4; i++) {
			if (arr[i][index12[i]]==1){
				total+=Math.pow(2, i-1);
			}
		}
		System.out.println(total);
	}
}
