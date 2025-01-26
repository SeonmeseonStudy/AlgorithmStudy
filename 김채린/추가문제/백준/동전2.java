import java.io.*;
import java.util.*;
/*
    0 1 2 3 4 5 6 7 8 9
0
1
5
12
* */
public class Main {
    static int[] n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] coin = new int[n[0]];
        int[][] arr = new int[n[0]+1][n[1] + 1];
        for(int i=0; i<=n[0]; i++) {
            Arrays.fill(arr[i], 10001);
        }
        for(int i=0; i<n[0]; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        for(int x=1; x<=n[1]; x++){
            for(int y=1; y<=n[0]; y++){
                if (coin[y-1]>x){
                    arr[y][x] = arr[y-1][x];
                }else {
                    arr[y][x] = Math.min(1+arr[y][x-coin[y-1]],arr[y-1][x]);
                }
            }
        }
        System.out.println(arr[n[0]][n[1]]);
    }
}
