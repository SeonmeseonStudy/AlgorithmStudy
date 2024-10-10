import java.util.*;

class Solution {
    int y;
    int x;
    char[][] board2;
    boolean[][] visited;
    public int solution(int m, int n, String[] board) {
        board2 = new char[m][n];
        for (int i = 0; i < m; i++) {
            board2[i] = board[i].toCharArray();
        }
        y = m;
        x = n;
        int total = 0;

        while (true) {
            visited = new boolean[m][n];
            int count = 0;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char now = board2[i][j];
                    if (now != '0' && isBoom(j, i, now)) {
                        visited[i][j] = true;
                        visited[i + 1][j] = true;
                        visited[i][j + 1] = true;
                        visited[i + 1][j + 1] = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        board2[i][j] = '0';
                        count++;
                    }
                }
            }

            if (count == 0) {
                break;
            }

            total += count;
            reload();
        }

        return total;
    }

    public boolean isBoom(int j, int i, char now) {
        return board2[i + 1][j] == now && board2[i][j + 1] == now && board2[i + 1][j + 1] == now;
    }

    private void reload() {
        for (int j = 0; j < x; j++) {
            Queue<Character> queue = new LinkedList<>();
            for (int i = y - 1; i >= 0; i--) {
                if (board2[i][j] != '0') {
                    queue.add(board2[i][j]);
                }
            }
            for (int i = y - 1; i >= 0; i--) {
                if (!queue.isEmpty()) {
                    board2[i][j] = queue.poll();
                } else {
                    board2[i][j] = '0';
                }
            }
        }
    }
}
