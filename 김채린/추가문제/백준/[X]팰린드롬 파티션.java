import java.io.*;
import java.util.*;

public class Main {
    static int num;
    static int[] result;
    static int[] arr;
    static HashSet<String> resultNum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        int max = 0;
        arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        result = new int[max + 1];
        Arrays.fill(result, 1);
        result[1] = 1;
        for (int i = 2; i <= max; i++) {
            if (i % 2 == 0) {
                for (int j = i - 2; j >= 0; j -= 2) {
                    result[i] += result[(i - j) / 2];
                }
            } else {
                result[i] = result[i - 1];
            }
        }
        for (int i=0; i<num; i++){
            System.out.println(result[arr[i]]);
        }
    }
}
