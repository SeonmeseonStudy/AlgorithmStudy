package 정민선.백준.한번더;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] board = new long[3];
        long[] boardMin = new long[3];

        String[] line = br.readLine().split(" ");
        board[0] = Long.parseLong(line[0]);
        board[1] = Long.parseLong(line[1]);
        board[2] = Long.parseLong(line[2]);

        boardMin[0] = Long.parseLong(line[0]);
        boardMin[1] = Long.parseLong(line[1]);
        boardMin[2] = Long.parseLong(line[2]);
        for (int i = 1; i < n; i++) {
            line = br.readLine().split(" ");
            
            long prev0 = board[0];
            long prev1 = board[1];
            long prev2 = board[2];

            board[0] = Math.max(prev0, prev1) + Long.parseLong(line[0]);
            board[1] = Math.max(Math.max(prev0, prev1), prev2) + Long.parseLong(line[1]);
            board[2] = Math.max(prev1, prev2) + Long.parseLong(line[2]);

            prev0 = boardMin[0];
            prev1 = boardMin[1];
            prev2 = boardMin[2];

            boardMin[0] = Math.min(prev0, prev1) + Long.parseLong(line[0]);
            boardMin[1] = Math.min(Math.min(prev0, prev1), prev2) + Long.parseLong(line[1]);
            boardMin[2] = Math.min(prev1, prev2) + Long.parseLong(line[2]);

        }
        System.out.println(Math.max(board[0], Math.max(board[1], board[2])) + " " + Math.min(boardMin[0], Math.min(boardMin[1], boardMin[2])));
    }
}