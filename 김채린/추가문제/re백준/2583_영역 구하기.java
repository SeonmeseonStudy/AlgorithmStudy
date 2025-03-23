import java.util.*;
import java.io.*;

public class Main {
    static int M, N, K;
    static int[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int size;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        result = new ArrayList<>();

        for(int i=0;i<K;i++) {
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1;y<y2;y++) {
                for(int x=x1;x<x2;x++) {
                    arr[y][x] = 1;
                }
            }
        }

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(arr[i][j] == 0) {
                    size=1;
                    sol(i, j);
                    result.add(size);
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size()+"\n");
        for(int r : result) {
            System.out.print(r+" ");
        }
    }

    public static void sol(int y, int x) {
        arr[y][x] = 1;

        for(int i=0;i<4;i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx>=0 && ny >=0 && nx<N && ny<M && arr[ny][nx]==0) {
                size++;
                sol(ny,nx);
            }
        }
    }
}
