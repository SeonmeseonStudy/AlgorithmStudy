import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws Exception{
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] xy=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[xy[0]][xy[1]];
        for (int i=0; i<xy[0]; i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE);
        }
        int[] start = new int[]{-1,-1};
        for(int i=0; i<xy[0]; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (start[0]==-1) {
                for (int j = 0; j<xy[1]; j++){
                    if(arr[i][j]==2){
                        start[0] = i;
                        start[1]=j;
                        break;
                    }
                }
            }
        }
        boolean[][] visited = new boolean[xy[0]][xy[1]];
        for (int i=0; i<xy[0]; i++){
            Arrays.fill(visited[i],false);
        }
        int[][] result = new int[xy[0]][xy[1]];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0],start[1],0});
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i=0; i<4; i++){
                int newX = now[1]+dx[i];
                int newY = now[0]+dy[i];
                if (newX>=0&&newY>=0&&newX<xy[1]&&newY<xy[0]&&!visited[newY][newX]&&arr[newY][newX]==1){
                    visited[newY][newX] = true;
                    int count =  now[2]+1;
                    result[newY][newX]=count;
                    q.add(new int[] {newY,newX,count});
                }
            }
    }
        for (int i=0; i<xy[0]; i++){
            for (int j=0; j<xy[1]; j++){
                int b = result[i][j];
                if (b==0&&arr[i][j]==1){
                    System.out.print("-1 ");
                    continue;
                }
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }
}
