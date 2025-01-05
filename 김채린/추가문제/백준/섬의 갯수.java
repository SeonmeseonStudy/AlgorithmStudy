import java.io.*;
import java.util.*;

class Main {
    /*1 1
    0
    2 2
    0 1
    1 0
    3 2
    1 1 1
    1 1 1
    5 4
    1 0 1 0 0
    1 0 0 0 0
    1 0 1 0 1
    1 0 0 1 0
    5 4
    1 1 1 0 1
    1 0 1 0 1
    1 0 1 0 1
    1 0 1 1 1
    5 5
    1 0 1 0 1
    0 0 0 0 0
    1 0 1 0 1
    0 0 0 0 0
    1 0 1 0 1
    0 0*/
    static int[][] arr;
    static Boolean[][] visited;
    static int[] dx = {1,-1,1,-1,1,-1,0,0};
    static int[] dy ={0,0,1,1,-1,-1,1,-1};
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (n[0]==0&&n[1]==0){
                break;
            }
            arr= new int[n[1]][n[0]];
            for(int i=0; i<n[1]; i++) {
                arr[i]= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            visited = new Boolean[n[1]][n[0]];
            for(int i=0; i<n[1]; i++) {
                Arrays.fill(visited[i], false);
            }
            count=0;
            for(int i= 0;i< arr.length; i++) {
                for(int j=0; j< arr[0].length;j++){
                    if (!visited[i][j]&&arr[i][j]==1) {
                        visited[i][j] =true;
                        dfs(i, j);
                        count++;
                    }else {
                        visited[i][j] = true;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int y,int x){
        for (int i=0; i< dx.length;i++){
            int newX = dx[i]+x;
            int newY = dy[i]+y;
            if(newX>=0&&newY>=0&&newX<arr[0].length&&newY<arr.length&&!visited[newY][newX]) {
                visited[newY][newX]=true;
                if(arr[newY][newX]==1){
                    dfs(newY, newX);
                }
            }
        }
    }
}
