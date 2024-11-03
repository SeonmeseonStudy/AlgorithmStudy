import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] board, int[] moves) {

        Queue<Integer>[] q = new Queue[board.length + 1];
        for (int i = 0; i <= board.length; i++) {
            q[i] = new LinkedList<>();
        }
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length; j++){
                if (board[i][j]==0){
                    continue;
                }
                q[j+1].add(board[i][j]);
            }
        }

        int count=0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<moves.length; i++){
            if (q[moves[i]].isEmpty()){
                continue;
            }
            int now = q[moves[i]].poll();
            if (result.size()>0&&result.get(result.size()-1)==now){
                count+=2;
                result.remove(result.size()-1);
                continue;
            }
            result.add(now);
        }
        return count;
    }
}
