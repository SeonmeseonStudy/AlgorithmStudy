import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int[][] result = new int[arr.length+1][26];
        for (int i=1; i<=26; i++){
            for (int j=1; j<=arr.length; j++) {
                result[j][i - 1] = result[j-1][i - 1];
                if (arr[j - 1] - 'a' == i - 1) {
                    result[j][i - 1]++;
                }
            }
        }
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
            String[] now = br.readLine().split(" ");
            int start = Integer.parseInt(now[1]);
            int end = Integer.parseInt(now[2])+1;
            int find = now[0].charAt(0)-'a';
            sb.append(result[end][find]- result[start][find]).append("\n");
        }
        System.out.println(sb);
    }
}
