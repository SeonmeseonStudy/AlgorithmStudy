import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n==1){
            System.out.println(sc.nextInt());
            return;
        }else if(n==2){
            System.out.println(sc.nextInt()+sc.nextInt());
            return;
        }
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
        }
        int[] result = new int[n+1];
        result[1] = arr[1];
        result[2] = arr[2]+arr[1];
        for (int i=3; i<=n; i++){
            result[i] = Math.max(arr[i]+result[i-2], arr[i]+result[i-3]+arr[i-1]);
        }
        System.out.println(result[n]);
    }
}
