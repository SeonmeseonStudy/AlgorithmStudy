import java.util.*;
import java.io.*;
public class Main {
    /*5
    RRRBB
    GGBBB
    BBBRR
    BBRRR
    RRRRR*/
    static boolean[][] visited1;
    static boolean[][] visited2;
    static String[] arr;
    static int n;
    static int[] dy = {1,-1,0,0};
    static int[] dx={0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];
        arr = new String[n];
        int count1=0;
        int count2=0;
        for (int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited1[i][j]) {
                    visited1[i][j] = true;
                    sol1(i, j);
                    count1++;
                }
                if (!visited2[i][j]) {
                    visited2[i][j]=true;
                    sol2(i, j,arr[i].charAt(j));
                    count2++;
                }
            }
        }
        System.out.println(count1+" "+count2);
    }
    public static void sol1(int y, int x){
        for(int i=0; i<4; i++){
            int newY=y+dy[i];
            int newX=x+dx[i];
            if(newX>=0&&newY>=0&&newX<n&&newY<n&&!visited1[newY][newX]&&arr[y].charAt(x)==arr[newY].charAt(newX)){
                visited1[newY][newX]=true;
                sol1(newY, newX);
            }
        }
    }

    public static void sol2(int y, int x, char color){
        for(int i=0; i<4; i++){
            int newY=y+dy[i];
            int newX=x+dx[i];
            if(newX>=0&&newY>=0&&newX<n&&newY<n&&!visited2[newY][newX]){
                if (((color=='R'||color=='G')&&(arr[newY].charAt(newX)=='R'||arr[newY].charAt(newX)=='G'))||(color=='B'&&arr[newY].charAt(newX)=='B')){
                    visited2[newY][newX]=true;
                    sol2(newY,newX,color);
                }
            }
        }
    }
}
