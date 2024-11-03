import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[nums[0]][3];
        for(int i=0; i<nums[0]; i++){
            arr[i] =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] result = new int[nums[1]+1];
        for (int i=1; i<=nums[1]; i++) {
            result[i] = Math.min(i, result[i-1] + 1);
            for (int j = 0; j < nums[0]; j++) {
                if (arr[j][1] == i) {
                    result[i] = Math.min(result[i], result[arr[j][0]] + arr[j][2]);
                }
            }
        }
        System.out.print(result[nums[1]]);
    }
}
