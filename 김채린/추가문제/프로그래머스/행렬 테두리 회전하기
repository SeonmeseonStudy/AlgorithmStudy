import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] q= {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        s.solution(6,6,q);
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        int count =1;
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                arr[i][j] = count++;
            }
        }
        int[] result = new int[queries.length];
        int n = 0;
        for (int[] query:queries){
            int startY= query[0]-1;
            int startX = query[1]-1;
            int endY = query[2]-1;
            int endX = query[3]-1;
            Queue<Integer> q = new LinkedList<>();
            int min=Integer.MAX_VALUE;
            for (int j=startX; j<=endX; j++){
                    if (q.isEmpty()){
                        q.add(arr[startY][j]);
                        continue;
                    }
                    q.add(arr[startY][j]);
                    arr[startY][j] =q.poll();
                    min = Math.min(min,arr[startY][j]);
                }
        for (int j=startY+1; j<=endY; j++){
            q.add(arr[j][endX]);
            arr[j][endX] =q.poll();
            min = Math.min(min,arr[j][endX]);
        }
            for (int j=endX-1; j>=startX; j--){
                q.add(arr[endY][j]);
                arr[endY][j] =q.poll();
                min = Math.min(min,arr[endY][j]);
            }
            for (int j=endY-1; j>=startY; j--){
                q.add(arr[j][startX]);
                arr[j][startX] =q.poll();
                min = Math.min(min,arr[j][startX]);
            }
            result[n]=min;
            n++;
        }
        return result;
    }
}
