import java.io.*;
import java.util.*;


public class Main {

    static int n;
    static int t;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        dp = new int[t+1];

        int all = 0;
        while (n-- > 0) {
            int d = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            all += m;

            for (int i = t; i >= 0; i--) {
                if (i < d) break;
                dp[i] = Math.max(dp[i], dp[i-d] +m);
            }
        }
        System.out.println(all - dp[t]);
    }

}
