import java.io.*;
import java.util.*;
public class Main {
    static int num;
    static int[][] arr;
    static int maxCount =1;
    static boolean[][] visited;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    /*5
    6 8 2 6 2
    3 2 3 4 6
    6 7 3 3 2
    7 2 5 3 6
    8 9 5 2 7*/
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num =Integer.parseInt(br.readLine());
        arr = new int[num][num];
        for(int i=0; i<num; i++){
            arr[i] =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int index = 1;
        while (true){
            int count=0;
            visited= new boolean[num][num];
            for(int i=0; i<num; i++){
                for (int j=0; j<num; j++){
                    if(!visited[i][j]&&arr[i][j]>index){
                        visited[i][j]=true;
                        count++;
                        sol2(i,j,index);
                    }
                }
            }
            if(count==0){
                break;
            }
            if (maxCount<=count){
                maxCount=count;
            }
            index++;
        }
        System.out.println(maxCount);
    }

    public static void sol2(int y, int x, int index) {
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newY >= 0 && newX >= 0 && newY < num && newX < num && !visited[newY][newX]&&arr[newY][newX]>index) {
                visited[newY][newX] = true;
                sol2(newY, newX,index);
            }
        }
    }
}
