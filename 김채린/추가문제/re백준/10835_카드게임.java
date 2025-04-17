import java.util.*;
import java.io.*;
class Main{
    static int n;
    static ArrayList<String> result;
    static int[] a;
    static int [] b;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sol(0,0,0);
        System.out.print(dp[0][0]);
    }

    public static int sol(int left, int right, int total) {
        if(left==n||right==n){
            return 0;
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        int result1 =sol(left+1, right,total);
        int result2 =sol(left+1,right+1,total);
        int result3 = total;
        if (a[left] > b[right]) {
            result3 = sol(left, right + 1, total);
            result3 += b[right];
        }
        dp[left][right] = Math.max(result1, Math.max(result2, result3));
        return dp[left][right];
    }
}
