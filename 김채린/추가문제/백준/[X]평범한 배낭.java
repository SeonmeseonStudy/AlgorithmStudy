import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[nums[0]][nums[1]+1];
        int[][] thing = new int[nums[0]][2];
        for (int i = 0; i < nums[0]; i++) {
            thing[i]= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int j=1; j<=nums[1]; j++){
            if (j<thing[0][0]){
                continue;
            }
            arr[0][j] = thing[0][1];
        }
        for (int i=1; i<nums[0]; i++) {
            for (int j = 1; j <= nums[1]; j++) {
                if (j < thing[i][0]) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = Math.max(thing[i][1] + arr[i - 1][j - thing[i][0]], arr[i - 1][j]);
                }
            }
        }
        System.out.println(arr[nums[0]-1][nums[1]]);
    }
}
