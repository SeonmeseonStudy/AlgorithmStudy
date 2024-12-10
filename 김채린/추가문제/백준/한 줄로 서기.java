import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[n];
        for (int i=0; i<arr.length; i++){
            int a =arr[i];
            int b =0;
            int count=0;
            while (true){
                if (count==a) {
                    while (result[b]!=0){
                        b++;
                    }
                    result[b] = i+1;
                    break;
                }
                if (result[b]==0){
                    count++;
                }
                b++;
            }
        }
        for (int a: result){
        System.out.print(a+" ");
    }}
}
