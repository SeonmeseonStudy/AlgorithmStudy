import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    static int[][] arr;
    static long[][] result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr =new int[num[0]+1][2];
        for(int i=1; i<=num[0]; i++){
            arr[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        result = new long[num[0]+1][num[1]+1];
        Arrays.sort(arr, (a,b)-> {
            if (a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });
        for (int j=1; j<=num[1]; j++){
            for (int i=1; i<=num[0]; i++){
                if (arr[i][0]>j){
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                    continue;
                }
                result[i][j] = Math.max(result[i-1][j], Math.max(result[i][j-1],arr[i][1]+result[i-1][j-arr[i][0]]));
            }
        }
        System.out.println(result[num[0]][num[1]]);
    }
}
