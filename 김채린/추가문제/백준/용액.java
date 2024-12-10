import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr =Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);
        int left=0;
        int right=n-1;
        int resultLeft=0;
        int resultRight=0;
        long min = Long.MAX_VALUE;
        while (left<right){
            long a= arr[right] + arr[left];
            if (min>=Math.abs(a)){
                resultLeft=left;
                resultRight=right;
                min = Math.abs(a);
            }
            if (a>0){
                right--;
            }else if (a<0){
                left++;
            }else {
                System.out.println(arr[left] +" " +arr[right]);
                return;
            }
        }
        System.out.println(arr[resultLeft] +" " +arr[resultRight]);
    }
}
