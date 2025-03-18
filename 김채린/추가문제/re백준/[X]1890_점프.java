import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int[][] arr;
    static int[] dy = {0,1};
    static int[] dx = {1,0};
    static long[][]result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        result = new long[n][n];
        for (int i=0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(result[i],-1);
        }
        System.out.println( sol(0,0));
    }

    public static long sol(int y, int x){
        if (y==n-1&&x==n-1){
            return 1;
        }
        if (result[y][x]==-1){
            int now = arr[y][x];
            if (now == 0) {
                return 0;
            }
            result[y][x] = 0;
            for (int i = 0; i < 2; i++) {
                int newY = y + (dy[i] * now);
                int newX = x + (dx[i] * now);
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    result[y][x] = Math.max(result[y][x] + sol(newY, newX), result[y][x]);
                }
            }
        }
        return result[y][x];
    }
}
