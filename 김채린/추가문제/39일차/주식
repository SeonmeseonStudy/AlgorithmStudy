import java.io.*;
import java.util.*;
class Main {
    static int max = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++){
           int n2 = Integer.parseInt(bufferedReader.readLine());
           int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           max = arr[n2-1];
           long total =0;
           for (int k=n2-2; k>=0;k--){
                       if (max<arr[k]) {
                           max=arr[k];
                       } else if (max>arr[k]) {
                           total+=max-arr[k];
                       }
               }
           sb.append(total).append("\n");
        }
        System.out.print(sb);
    }
}
