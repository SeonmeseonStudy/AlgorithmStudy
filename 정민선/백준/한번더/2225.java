package 정민선.백준.한번더;
import java.util.*;
import java.io.*;

class B2225 {
    static int MOD = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
    
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[][] dp = new int[k+1][n+1];

        for (int i=0; i<=n; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=k; i++) {
            for (int j=0; j<=n; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
                }

            }
        }

        System.out.println(dp[k][n]);
    }
}