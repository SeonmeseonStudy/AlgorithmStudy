import java.util.*;
import java.io.*;
import java.math.*;

/*6
6
10
13
9
8
1

result : 33
*/
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n+1];
        long[] result = new long[n+1];
        for (int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(arr[1]);
            return;
        } else if (n == 2) {
            System.out.println(arr[1] + arr[2]);
            return;
        }

        result[1] = arr[1];
        result[2] = arr[1] + arr[2];

            for (int i = 3; i<=n; i++){
                result[i] = Math.max(result[i-1],Math.max(arr[i]+arr[i-1]+result[i-3],arr[i]+result[i-2]));
            }
        System.out.println(result[n]);
    }
}
