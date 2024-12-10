import java.util.*;
import java.io.*;
/*6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1*/
class Main{
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w=sc.nextInt();
        int h=sc.nextInt();
        int[][] arr = new int[h][w];
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        boolean[][] visitied =  new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
        int count=0;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++) {
                if(arr[i][j]==1){
                    visitied[i][j] = true;
                    q.add(new int[]{i,j,0});
                }
            }
        }

        while (!q.isEmpty()){
            int[] now = q.poll();
            count = Math.max(count,now[2]);
            for(int k=0; k<4; k++) {
                int newY = now[0] + dy[k];
                int newX = now[1] + dx[k];
                if (newY>=0&&newY<h&&newX>=0&&newX<w&&arr[newY][newX]!=-1&&!visitied[newY][newX]){
                    if (arr[newY][newX]==0){
                        visitied[newY][newX] =true;
                        q.add(new int[]{newY,newX,now[2]+1});
                    }else {
                        visitied[newY][newX] =true;
                        q.add(new int[]{newY,newX,0});
                    }
                }
            }
        }

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++) {
                if(!visitied[i][j]&&arr[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
}
