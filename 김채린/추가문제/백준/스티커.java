import java.util.*;
import java.io.*;
class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][num];
            for (int j = 0; j < 2; j++) {
                arr[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            }
            int[][] result = new int[2][num + 1];
            result[0][1] = arr[0][0];
            result[1][1] = arr[1][0];
            for (int j = 2; j <= num; j++) {
                result[0][j] =Math.max(result[1][j-1]+arr[0][j-1],result[0][j-1]);
                result[1][j] =Math.max(result[0][j-1]+arr[1][j-1],result[1][j-1]);
            }
            System.out.println(Math.max(result[0][num],result[1][num]));
        }
    }
}
