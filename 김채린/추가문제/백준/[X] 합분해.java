import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp= new int[n[0]+1][n[1]+1];
        for(int i=0;i<=n[0];i++){
            dp[i][1] = 1;
        }
        for(int i=0;i<=n[1];i++){
            dp[1][i] = i;
        }

        for(int i=2;i<=n[0];i++){
            for(int j=2;j<=n[1];j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        System.out.println(dp[n[0]][n[1]]);
    }
}
