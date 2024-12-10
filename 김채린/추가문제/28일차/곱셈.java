import java.util.*;
import java.io.*;

public class Main {
    static int l;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        l = n[2];
        System.out.println(sol(n[0],n[1]));
    }

    public static long sol(int n, int m){
        if (m==0){
            return 1;
        }
        long num = sol(n,m/2);
        if (m%2==0){
             return num*num%l;
        }else {
            return (num*num%l)*n%l;
        }
    }
}
