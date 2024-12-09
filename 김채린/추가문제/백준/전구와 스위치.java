import java.io.*;
import java.util.*;
// 검색 풀이
public class Main {
    static boolean change = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream((br.readLine()).split("")).filter(it -> !it.equals(""))
            .mapToInt(Integer::parseInt).toArray();
        int[] resultArr = Arrays.stream(br.readLine().split("")).filter(it -> !it.equals(""))
            .mapToInt(Integer::parseInt).toArray();
        int a=sol(true,arr.clone(),resultArr);
        int b=sol(false,arr.clone(),resultArr);
        int result = Math.min(a,b);
        if (result==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }

    public static int sol(boolean press,int[] arr, int[] target){
        int count=0;
        if (press){
            arr[0]= (arr[0]+1)%2;
            arr[1]=(arr[1]+1)%2;
            count++;
        }
        for (int i=1; i<arr.length; i++){
            if (arr[i-1] != target[i-1]){
                arr[i-1]= (arr[i-1]+1)%2;
                arr[i]= (arr[i]+1)%2;
                if (i<arr.length-1){
                    arr[i+1] =(arr[i+1]+1)%2;
                }
                count++;
            }
        }
        boolean isSame = true;
        for (int i=0; i<arr.length; i++){
            if (arr[i]!=target[i]){
                isSame=false;
                break;
            }
        }
        if (isSame){
            return count;
        }
        return Integer.MAX_VALUE;
    }
}
