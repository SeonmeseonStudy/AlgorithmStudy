import java.io.*;
import java.util.*;
// 쉬운 문제인데. 틀림
public class Main {

    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        result = new int[num];
        int max = 0;
        Arrays.fill(result, 1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    result[i] = Math.max(result[j]+1, result[i]);
                }
            }
            max = Math.max(max,result[i]);
        }
        System.out.println(max);
    }
}
