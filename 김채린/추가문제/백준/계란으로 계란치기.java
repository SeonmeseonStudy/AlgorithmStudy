import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int result=0;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][2];
        int[] egg = new int[n];
        for (int i= 0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            egg[i]=arr[i][0];
        }
        sol(0,0, egg);
        System.out.println(result);
    }

    public static void sol(int index, int count, int[] egg) {
        if (index==n){
            result = Math.max(result,count);
            return;
        }
        if (egg[index]<=0){
            sol(index+1,count,egg);
            return;
        }
        boolean isBroken = false;
        for (int i=0; i<n; i++) {
            if (i!=index&&egg[i]>0){
                if (!isBroken){
                    isBroken=true;
                }
                int plus = 0;
                egg[index]-=arr[i][1];
                if (egg[index]<=0){
                    plus++;
                }
                egg[i]-=arr[index][1];
                if (egg[i]<=0){
                    plus++;
                }
                if (count+plus==n){
                    result = Math.max(result,count+plus);
                    return;
                }
                sol(index+1,count+plus,egg);
                egg[i]+=arr[index][1];
                egg[index]+=arr[i][1];
            }
        }
        if (!isBroken){
            sol(index+1,count,egg);
        }
    }
}
