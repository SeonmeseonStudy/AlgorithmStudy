import java.io.*;
import java.util.*;

public class Main {
    private static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][2 * n - 1];
        for (int i = 0; i<n; i++) {
            Arrays.fill(map[i],' ');
        }
        drawStar(0, n-1, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void drawStar(int y, int x, int n) {
        if (n == 3) {
            map[y][x] = '*';
            map[y + 1][x - 1] = map[y + 1][x + 1] = '*';
            map[y + 2][x-2]=map[y + 2][x-1]=map[y + 2][x]=map[y + 2][x+1]=map[y + 2][x+2]='*';
            return;
        }

        drawStar(y,x,n/2);
        drawStar(y+n/2,x-n/2,n/2);
        drawStar(y+n/2, x+n/2,n/2);
    }
}
