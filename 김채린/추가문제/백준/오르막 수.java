import java.io.*;
import java.util.*;

public class Main {
    static int num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][10];
        Arrays.fill(arr[0],1);
        for(int i=1; i<num; i++){
            for(int j=0; j<10; j++){
                for(int k=j; k<10; k++){
                    arr[i][j] += arr[i-1][k];
                    arr[i][j]%=10007;
                }
            }
        }
        int total = 0;
        for (int i=0; i<10; i++){
            total+=arr[num-1][i];
        }
        System.out.println(total%10007);
    }
}
