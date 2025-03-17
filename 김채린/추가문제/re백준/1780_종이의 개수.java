    /*9
        0 0 0 1 1 1 -1 -1 -1
        0 0 0 1 1 1 -1 -1 -1
        0 0 0 1 1 1 -1 -1 -1
        1 1 1 0 0 0 0 0 0
        1 1 1 0 0 0 0 0 0
        1 1 1 0 0 0 0 0 0
        0 1 -1 0 1 -1 0 1 -1
        0 -1 1 0 1 -1 0 1 -1
        0 1 -1 1 0 -1 0 1 -1
        */
import java.util.*;
import java.io.*;

class Main {
    static int[] result = new int[3];
    public static void main(String[] args) {
        BufferedRead br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        sol(0,0,n);
    }

    public static void sol(int y, int x, int size){
        int now = arr[y][x];
        for(int i = y; i<y+n; i++) {
            for (int j = x; j < x + n; j++) {
                if (i == y && j == x) {
                    continue;
                }
                if (arr[i][j] != now) {
                    int newSize = n / 3;
                    for (int a = y; a < y + n; a = a + newSize) {
                        for (int b = x; b < x + n; b = b + newSize) {
                            sol(a, b, newSize);
                        }
                    }
                    return;
                }
            }
        }
        result[now+1]++;
    }
}
