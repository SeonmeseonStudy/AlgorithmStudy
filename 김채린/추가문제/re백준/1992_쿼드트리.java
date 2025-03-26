import java.io.*;
import java.util.*;

class Main{
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i=0; i<n; i++){
            arr[i]= Arrays.stream(br.readLine().split("")).filter(it-> !it.equals(" ")).mapToInt(Integer::parseInt).toArray();
        }
        sol(0,0,n);
    }

    public static void sol(int y, int x, int size){
        int now = arr[y][x];
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if (now!=arr[i][j]){
                    System.out.print("(");
                    int newSize = size/2;
                    sol(y,x,newSize);
                    sol(y,x+newSize,newSize);
                    sol(y+newSize,x,newSize);
                    sol(y+newSize,x+newSize,newSize);
                    System.out.print(")");
                    return;
                }
            }
        }
        System.out.print(now);
    }
}
