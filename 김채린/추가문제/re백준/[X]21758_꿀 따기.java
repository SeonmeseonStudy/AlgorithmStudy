import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] honey = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long[] sum = new long[n];
        sum[0] = honey[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + honey[i];
        }

        long answer = 0;
        for (int i = 1; i < n - 1; i++) {
            long result = sum[n-1] - honey[n-1] + sum[i-1] - honey[i];
            answer = Math.max(answer, result);
        }

        for (int i = 1; i < n - 1; i++) {
            long result = (sum[n-1]*2)- honey[i] - honey[0]-sum[i];
            answer = Math.max(answer, result);
        }

        for (int i = 1; i < n - 1; i++) {
            long result = sum[i]-honey[0]-honey[n-1]-sum[i-1]+sum[n-1];
            answer = Math.max(answer, result);
        }

        System.out.println(answer);
    }
}
