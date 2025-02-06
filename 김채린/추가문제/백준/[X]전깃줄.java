import java.util.*;
public class Main {
    static  int num;
    static int[][] arr;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num =sc.nextInt();
        arr = new int[num][2];
        for (int i = 0; i < num; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        dp = new int[num];
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int max =0;
        for(int i=0; i<num; i++){
            max=Math.max(sol(i),max);
        }
        System.out.println(num-max);
    }

    public static int sol(int number) {
        if (dp[number]==0) {
            dp[number]=1;
            int[] now = arr[number];
            for (int i = number + 1; i < num; i++) {
                if (now[1] < arr[i][1]) {
                    dp[number] = Math.max(dp[number], sol(i) + 1);
                }
            }
        }
        return dp[number];
    }
}
