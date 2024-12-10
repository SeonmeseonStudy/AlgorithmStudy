import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int remainder = Integer.parseInt(br.readLine());
        int now =0;
        int length =arr.length;
        int a=0;
        while (n>0){
            a= remainder/n;
            if (a<arr[now]){
                break;
            }
            for (int i=now; i< length; i++){
                if (a>=arr[i]){
                    remainder-=arr[i];
                    n--;
                    now++;
                    if (n==0){
                        a=arr[length-1];
                    }
                }else {
                    break;
                }
            }
        }
        System.out.println(a);
    }
}
