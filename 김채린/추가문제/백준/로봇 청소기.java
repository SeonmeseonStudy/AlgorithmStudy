import java.io.*;
import java.util.*;
public class Main {
    static int[] num;
    static int[][] arr;
    static int count=0;
    static int[] dy = {-1,0,1,0};
    static int[] dx ={0,1,0,-1};
    static int d;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = new int[num[0]][num[1]];
        int[] robot = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        d = robot[2];
        for(int i=0; i<num[0]; i++){
            arr[i] =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        sol(robot[0],robot[1]);
        System.out.println(count);
    }

    public static void sol(int y,int x){
        if (arr[y][x]==0){
            count++;
            arr[y][x] =2;
        }
        for(int i=0; i<4; i++){
            int index = (4-(i+1)+d)%4;
            int newY = y+dy[index];
            int newX = x+dx[index];
            if (newY>=0&&newY<num[0]&&newX>=0&&newX<num[1]&&arr[newY][newX]==0){
                d=index;
                sol(newY,newX);
                return;
            }
        }
        int index = (d+2)%4;
        int newY = y+dy[index];
        int newX = x+dx[index];
        if (newY<0||newX<0||newY>=num[0]||newX>=num[1]||arr[newY][newX]==1){
            return;
        }else {
            sol(newY,newX);
        }
    }
}
