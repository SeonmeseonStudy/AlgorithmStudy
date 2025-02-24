import java.io.*;
import java.util.*;

public class Main {
    static int num;
    static int[][] arr;
    static long[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num =  Integer.parseInt(br.readLine());
        arr = new int[num][num];
        for(int i=0; i<num; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        visited = new long[num][num];
        visited[0][0] = 1;
        for(int i=0; i<num; i++){
            for (int j=0; j<num; j++){
                int now = arr[i][j];
                if (now==0){
                    break;
                }
                if (i+now<num){
                    visited[i+now][j]+=visited[i][j];
                }
                if (j+now<num){
                    visited[i][j+now] += visited[i][j];
                }
            }
        }
        System.out.println(visited[num-1][num-1]);
    }
}
