import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static long result =0;
    static long x;
    static long[] p;
    static long[] length;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextLong();
        p = new long[n+1];
        length =new long[n+1];
        p[0]=1;
        length[0] =1;
        for(int i=1;i<=n;i++){
            length[i] = length[i-1] * 2 + 3;
            p[i] = p[i-1] * 2 + 1;
        }
        sol1(n);
        System.out.println(result);
    }

    public static void sol1(int index) {
        if (x==0){
            return;
        }
        if (index==0){
            result++;
            x--;
            return;
        }
        if (length[index-1]+2>x){
            x--;
            sol1(index-1);
        }else if (length[index-1]+2==x){
            result+=p[index-1]+1;
        }else if (length[index-1]+2<x){
            result+=p[index-1]+1;
            x-=(length[index-1]+2);
            sol1(index-1);
        }
    }
}
