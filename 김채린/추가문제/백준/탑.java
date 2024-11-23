import java.util.*;
import java.io.*;
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[arr.length];
        for (int i = 1; i < result.length; i++) {
            int index = i;
            while (index > 0) {
                if (arr[index - 1] >= arr[i]) { // 같은것도 되나?
                    result[i] = index;
                    break;
                }
                index = result[index - 1];
                if (index - 1 == -1) {
                    break;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
