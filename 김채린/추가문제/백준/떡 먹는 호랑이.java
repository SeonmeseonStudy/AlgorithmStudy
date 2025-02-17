import java.io.*;
import java.util.*;
public class Main {
    static int d;
    static int k;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        d = sc.nextInt();
        k = sc.nextInt();
        arr = new int[d];
        arr[d-1] = k;
        for (int i= k/2+1; i<k; i++){
            if (sol(i)){
                System.out.println(arr[0]);
                System.out.println(arr[1]);
                return;
            }
        }
    }

    public static boolean sol(int num){
        arr[d-2] = num;
        for (int i= d-3; i>=0; i-- ){
            arr[i] = arr[i+2]-arr[i+1];
            if ((arr[i]>arr[i+1])||arr[i]<=0){
                return false;
            }
        }
        return true;
    }
}
