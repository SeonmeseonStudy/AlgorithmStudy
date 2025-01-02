import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arr = new int[m];
        solve(n, 0, m, arr, sb, 1);
        System.out.print(sb.toString());
    }

    public static void solve(int n, int count, int end, int[] arr, StringBuilder sb, int now) {
        if (count == end) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = now; i <= n; i++) {
            arr[count] = i;
            solve(n, count + 1, end, arr, sb, i);
        }
    }
}
