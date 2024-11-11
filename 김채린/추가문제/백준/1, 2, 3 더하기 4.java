import java.util.*;
import java.io.*;
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] nums = new int[num];
        int max =0;
        for(int i=0; i<num; i++){
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,nums[i]);
        }
        int[][] result = new int[max+1][3];
        for (int i=1; i<=3; i++){
            for(int j=0; j<i; j++) {
                result[i][j] = 1;
            }
        }
        for(int i=4; i<=max; i++){
            result[i][0] = result[i-1][0];
            result[i][1] = result[i-2][0]+result[i-2][1];
            result[i][2] = result[i-3][0]+result[i-3][1]+result[i-3][2];
        }
        for (int i:nums){
            System.out.println(result[i][0]+result[i][1]+result[i][2]);
        }
    }}
