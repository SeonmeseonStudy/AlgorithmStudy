import java.io.*;
import java.util.*;
public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] newMax = new int[3];
        int[] newMin = new int[3];
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        newMax[0] = a;
        newMax[1] = b;
        newMax[2] = c;

        newMin[0] = a;
        newMin[1] = b;
        newMin[2] = c;
        for (int i= 0; i<n-1; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            int bigger = Math.max(newMax[0],newMax[1]);
            int bigger2 =Math.max(newMax[1], newMax[2]);
            int smaller =Math.min(newMin[0], newMin[1]);
            int smaller2 = Math.min(newMin[1], newMin[2]);
            newMax[0] = bigger+a;
            newMax[1] = Math.max(bigger, bigger2)+b;
            newMax[2] = bigger2+c;
            newMin[0] = smaller+a;
            newMin[1] = Math.min(smaller2, smaller)+b;
            newMin[2] = smaller2+c;
        }
        System.out.print(Math.max(newMax[0], Math.max(newMax[1],newMax[2])));
        System.out.println(" "+Math.min(newMin[0], Math.min(newMin[1],newMin[2])));
    }
}
