import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        long[] alphabet = new long[26];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                alphabet[line.charAt(j) - 'A'] += ((i+1)*(2*n-i)+(i+n+1)*(n-i))*((j+1)*(2*m-j)+(j+m+1)*(m-j));
            }
        }

        for (long count : alphabet) {
            System.out.println(count);
        }
    }
}