import java.io.*;
import java.util.*;
// 쉬운 문제인데. 틀림
public class Main {
static int[][][] result = new int[21][21][21];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a==-1&&b==-1&&c==-1){
                break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(sol(a,b,c));
            System.out.println(sb);
        }
    }

    public static int sol(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20) {
            if (result[20][20][20]==0){
                result[20][20][20] = sol(20,20,20);
            }
            return result[20][20][20];
        }
        if (a < b && b < c) {
            if (result[a][b][c]==0){
                result[a][b][c] = sol(a, b, c - 1) + sol(a, b - 1, c - 1) - sol(a, b - 1, c);
            }
           return result[a][b][c];
        } else {
            if (result[a][b][c]==0) {
                result[a][b][c] =
                    sol(a - 1, b, c) + sol(a - 1, b - 1, c) + sol(a - 1, b, c - 1) - sol(a - 1,
                        b - 1, c - 1);
            }
            return result[a][b][c];
        }
    }
}
