import java.io.*;

public class Main {
    private static long taling(int num) {
        if (num == 1) {
            return 1;
        }
        Long[] result = new Long[num + 1];
        result[1] = 1L;
        result[2] = 3L;
        for (int i = 3; i <= num; i++) {
            result[i] = (result[i - 2] * 2 + result[i - 1])%10007;
        }
        return result[num];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(taling(num));
    }
}
