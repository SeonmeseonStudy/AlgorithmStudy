import java.io.*;
import java.util.*;
public class Main {
    /*4
    1 5 6 7
       0 1 2 3 4
    0 0 0 0 0
    1 0 1 2
    5 0 0 5
    6 0 0 5
    7 0 0 5
    */
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] result = new int[arr.length+1][num+1];
        for(int x=1; x<=num; x++){
            for(int y=1; y<=arr.length; y++){
                if(y>x){
                    result[y][x] = result[y-1][x];
                    continue;
                }
                result[y][x] = Math.max(arr[y-1]+result[x-y][x-y] , result[y-1][x]);
            }
        }
        System.out.println(result[arr.length][num]);
    }
}
