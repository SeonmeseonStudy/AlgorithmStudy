import java.io.*;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = nums[0];
        int M = nums[1];
        int max = 0;
        int[][] arr = new int[N][M];
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).filter(it-> !it.equals("")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i=0; i<N; i++){
            result[i] = arr[i];
            for (int j = 0; j < M; j++) {
                if (i >= 1 && j >= 1) {
                    if (result[i - 1][j] > 0 && result[i - 1][j - 1] > 0 && result[i][j - 1] > 0
                        && result[i][j] > 0) {
                        int min = Math.min(result[i - 1][j],
                            Math.min(result[i - 1][j - 1], result[i][j - 1]));
                        result[i][j] = min + 1;
                    }
                }
                max = Math.max(max, result[i][j]);
            }
        }
        System.out.println(max * max);
    }
}
