import java.io.*;
import java.util.*;
/*0 1 2 3 4 5 6 7
0
6
4
3
5 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(it->Integer.parseInt(it)).toArray();
        int[][] arr = new int[nums[0]][2];
        int[][] result = new int[nums[0]+1][nums[1]+1];
        for(int i=0; i<nums[0]; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int x=1; x<=nums[1];x++){
            for(int y=1; y<=nums[0]; y++){
                if (arr[y-1][0]>x){
                    result[y][x]=result[y-1][x];
                }else{
                    result[y][x] = Math.max(arr[y-1][1]+result[y-1][x-arr[y-1][0]],result[y-1][x]);
                }
            }
        }
        System.out.println(result[nums[0]][nums[1]]);
    }
}
