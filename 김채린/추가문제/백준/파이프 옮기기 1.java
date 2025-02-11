import java.io.*;
import java.util.*;
public class Main {
    static int[][] arr;
    static int[] dx = {1,0,1};
    static int[] dy = {0,1,1};
    static int n;
    static int result =0;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0;j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int nowDirection = 0;
        int[] nowLocation = {0,1};
        sol1(nowDirection,nowLocation);
        System.out.println(result);
    }

    public static void sol1(int nowDirection, int[] nowLocation) {
        if (nowLocation[0]==n-1&&nowLocation[1]==n-1){
            result++;
            return;
        }
        if (nowDirection == 2) {
            for (int i = 0; i < 3; i++) {
                sol2(nowLocation[0],nowLocation[1],i);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (nowDirection == i || i == 2) {
                    sol2(nowLocation[0],nowLocation[1],i);
                }
            }
        }
    }

    public static void sol2(int y, int x, int i){
        int newY = y + dy[i];
        int newX = x + dx[i];
        if (newX >= 0 && newY >= 0 && newX < n && newY < n && arr[newY][newX] != 1) {
            if (i != 2 || (arr[newY - 1][newX] == 0 && arr[newY][newX - 1] == 0)) {
                sol1(i, new int[]{newY, newX});
            }
        }
    }
}
