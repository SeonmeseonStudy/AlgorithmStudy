import java.util.*;
import java.io.*;
class Main{
    static char[] arr;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        int result;
        if (arr[0]==arr[n-1]){
            int preCount =1;
            int i=1;
            char now = arr[0];
            while (i<n&&arr[i]==now){
                i++;
                preCount++;
            }
            if (preCount==n){
                System.out.println(0);
                return;
            }
            int postCount =1;
            i=n-2;
            while (i>=0&&arr[i]==now){
                i--;
                postCount++;
            }
            if (postCount>preCount){
                result= sol(now,postCount, 1);
            }else {
                result = sol(now, preCount, 0);
            }
            if (now=='R'){
                now = 'B';
            }else {
                now = 'R';
            }
            result = Math.min(result, sol(now,0,0));
        }else {
            int preCount =1;
            int i=1;
            while (i<n&&arr[i]==arr[0]){
                i++;
                preCount++;
            }
            int postCount =1;
            i=n-2;
            while (i>=0&&arr[i]==arr[n-1]){
                i--;
                postCount++;
            }
            if (preCount+postCount==n){
                System.out.println(0);
                return;
            }
            result= Math.min(sol(arr[n-1],postCount, 1),sol(arr[0], preCount, 0));
        }
        System.out.println(result);
    }

    public static int sol(char a, int count, int prePost){
        int totalCount = 0;
        if (prePost==0){
            for(int i=count; i<n; i++){
                if (a==arr[i]){
                    totalCount++;
                }
            }
        }else {
            for (int i=n-count-1; i>=0; i--){
                if (a==arr[i]){
                    totalCount++;
                }
            }
        }
        return totalCount;
    }
}
