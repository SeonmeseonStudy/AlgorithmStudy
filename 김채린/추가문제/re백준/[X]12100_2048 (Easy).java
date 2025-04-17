import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(board, 0);
        System.out.println(max);
    }

    static void dfs(int[][] board, int depth) {
        if (depth == 5) {
            max = Math.max(max, getMaxBlock(board));
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] copied = copy(board);
            move(copied, dir);
            dfs(copied, depth + 1);
        }
    }

    static int getMaxBlock(int[][] board) {
        int result = 0;
        for (int[] row : board) {
            for (int val : row) {
                result = Math.max(result, val);
            }
        }
        return result;
    }

    static int[][] copy(int[][] board) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }

    static void move(int[][] board, int dir) {
        for (int i = 0; i < N; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                int val;
                if (dir == 0) {
                    val = board[j][i];
                }else if (dir == 1) {
                    val = board[N - 1 - j][i];
                }else if (dir == 2) {
                    val = board[i][j];
                }else {
                        val = board[i][N - 1 - j];
                }
                if (val != 0) list.add(val);
            }

            LinkedList<Integer> merged = new LinkedList<>();
            while (!list.isEmpty()) {
                int a = list.poll();
                if (!list.isEmpty() && a == list.peek()) {
                    merged.add(a * 2);
                    list.poll();
                } else {
                    merged.add(a);
                }
            }

            while (merged.size() < N) merged.add(0);

            for (int j = 0; j < N; j++) {
                if (dir == 0) {
                    board[j][i] = merged.get(j); // up
                } else if (dir == 1) {
                    board[N - 1 - j][i] = merged.get(j); // down
                } else if (dir == 2) {
                    board[i][j] = merged.get(j); // left
                } else if (dir == 3) {
                    board[i][N - 1 - j] = merged.get(j); // right
                }
            }
        }
    }
}
