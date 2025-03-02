import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = new long[31];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= 30; i++) {
            long count = 0;

            for (int j = 0; j < i; j++) {
                count += arr[j] * arr[i - 1 - j];
            }

            arr[i] = count;
        }
        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            System.out.println(arr[N]);
        }
    }
}
