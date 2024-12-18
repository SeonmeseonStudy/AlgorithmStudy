import java.util.*;
import java.io.*;

class Main {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int X = num[0];
        int Y = num[1];
        int Z = num[2];
        int[][][] arr = new int[Z][Y][X];
        for (int z = 0; z < Z; z++) {
            for (int y = 0; y < Y; y++) {
                arr[z][y] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            }
        }
        boolean[][][] visited = new boolean[Z][Y][X];
        int max = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int z = 0; z < Z; z++) {
            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++)
                    if (arr[z][y][x] == 1) {
                        q.add(new int[]{z, y, x, 0});
                    }
            }
        }
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 6; i++) {
                max = Math.max(max, now[3]);
                int newZ = now[0] + dz[i];
                int newY = now[1] + dy[i];
                int newX = now[2] + dx[i];
                if (newX >= 0 && newY >= 0 && newZ >= 0 && newX < X && newY < Y && newZ < Z && !visited[newZ][newY][newX] && arr[newZ][newY][newX] == 0) {
                    visited[newZ][newY][newX]=true;
                    q.add(new int[]{newZ, newY, newX, now[3] + 1});
                }
            }
        }

        for (int z = 0; z < Z; z++) {
            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++)
                    if (arr[z][y][x] == 0 && !visited[z][y][x]) {
                        System.out.println(-1);
                        return;
                    }
            }
        }
        System.out.println(max);
    }
}
