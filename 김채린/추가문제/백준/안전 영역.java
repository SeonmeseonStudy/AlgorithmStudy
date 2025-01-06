import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int result=1;
    static int[] dx ={1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int height =1;
        while (true){
            int count=0;
            visited = new boolean[n][n];
            for(int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    if (!visited[i][j]&&arr[i][j]>height){
                        count++;
                        visited[i][j] = true;
                        sol(height,i,j);
                    }
                }
            }
            if (count==0){
                System.out.println(result);
                return;
            }
            result = Math.max(result,count);
            height++;
        }
    }

    public static void sol(int height, int y, int x){
        for(int i=0; i<4; i++){
            int newY = y+dy[i];
            int newX = x+dx[i];
            if (newX>=0&&newX<n&&newY>=0&&newY<n&&!visited[newY][newY]&&arr[newY][newX]>height){
                visited[newY][newX] = true;
                sol(height,newY,newX);
            }
        }
    }
}
