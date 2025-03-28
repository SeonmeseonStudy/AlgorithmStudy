import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] maxNum = new int[3];
        int[] minNum = new int[3];
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        maxNum[0] = a;
        maxNum[1] = b;
        maxNum[2] = c;
        minNum[0] = a;
        minNum[1] = b;
        minNum[2] = c;
        for (int i=1; i<n; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            int big1 = Math.max(maxNum[0],maxNum[1]);
            int big2 = Math.max(maxNum[1],maxNum[2]);
            int small1 = Math.min(minNum[0],minNum[1]);
            int small2 = Math.min(minNum[1],minNum[2]);
            maxNum[0] = big1+a;
            maxNum[1] = Math.max(big1,big2)+b;
            maxNum[2] = big2+c;
            minNum[0] = small1+a;
            minNum[1] = Math.min(small1,small2)+b;
            minNum[2] = small2+c;
        }
        System.out.println(Math.max(Math.max(maxNum[0],maxNum[1]),maxNum[2])+" "+Math.min(Math.min(minNum[0],minNum[1]),minNum[2]));
    }
}
