import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int[] num;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int result =0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = new char[num[0]][num[1]];
        for(int i=0; i<num[0]; i++){
            arr[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[num[0]][num[1]];
        visited[num[0]-1][0] = true;
        sol(1,num[0]-1,0,visited);
        System.out.println(result);
    }

    public static void sol(int count, int y, int x,boolean[][] visited){
        if (count==num[2]){
            if (y==0&&x==num[1]-1){
                result++;
            }
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (nx>=0&&nx<num[1]&&ny>=0&&ny<num[0]&&!visited[ny][nx]&&arr[ny][nx]=='.'){
                visited[ny][nx] = true;
                sol(count+1,ny,nx,visited);
                visited[ny][nx] = false;
            }
        }
    }
}
