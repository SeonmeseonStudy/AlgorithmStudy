import java.util.*;
class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr =new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for (int j=1; j<=N;j++){
                arr[i][j] = sc.nextInt()+ arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1];
            }
        }

        for(int i=0; i<M; i++){
            int y1 = sc.nextInt();
            int x1 = sc.nextInt();
            int y2 = sc.nextInt();
            int x2 = sc.nextInt();
            System.out.println(arr[y2][x2]-arr[y1-1][x2]-arr[y2][x1-1]+arr[y1-1][x1-1]);
        }
    }
}
