import java.util.*;
import java.math.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
        tri[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i=n-1; i>0; i--){
        for(int j=0; j<i;j++){
        tri[i][j]+= Math.max(tri[i+1][j],tri[i+1][j+1]);
        }
        }
        System.out.println(tri[1][0]);
        }
}
