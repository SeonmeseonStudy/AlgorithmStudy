// package 정민선.백준.etc;
import java.io.*;
import java.util.*;

class B1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] list = new int[n][2];
            for (int j=0; j<n; j++) {
                String[] volunteer = br.readLine().split(" ");
                int rank1 = Integer.parseInt(volunteer[0]);
                int rank2 = Integer.parseInt(volunteer[1]);

                list[j][0] = rank1;
                list[j][1] = rank2;
            }
            Arrays.sort(list, (rank1, rank2) -> {
                return rank1[0]-rank2[0];
            });

            int answer = 1;
            int maxRank = list[0][1];
            for (int[] rank : list) {
                int rank2 = rank[1];
                if (rank2 < maxRank) {
                    answer++;
                    maxRank = rank2;
                } 
            }

            System.out.println(answer);
        }
    }
}
