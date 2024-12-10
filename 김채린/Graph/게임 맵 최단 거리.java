import java.util.*;
class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n = 0;
    static int m = 0;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        while (q.size() > 0) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            int count = now[2];
            if (x == m - 1 && y == n - 1) {
                return count;
            }
            for (int i = 0; i < 4; i++) {
                int nowX = x + dx[i];
                int nowY = y + dy[i];
                if (isSave(nowX, nowY) && maps[nowY][nowX] != 0 && !visited[nowY][nowX]) {
                    visited[nowY][nowX] = true;
                    q.add(new int[]{nowY, nowX, count + 1});
                }
            }
        }
        return -1;
    }

    public boolean isSave(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        } else {
            return false;
        }
    }
public static void main(String[] args) {
        Solution s = new Solution();
        int[][] map = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        s.solution(map);
    }
}
