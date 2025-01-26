import java.io.*;
import java.util.*;
// 더 좋은 방법 찾아보기
public class Main {
    static int n;
    static int[] nArr;
    static int num;
    static int result;
    static int[] arr;
    static boolean[] impasible;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = Math.abs(100-n);
        nArr = Arrays.stream(Integer.toString(n).split("")).filter(it-> !it.equals("")).mapToInt(Integer::parseInt).toArray();
        num = Integer.parseInt(br.readLine());
        if (n==100){
            System.out.println(0);
            return;
        }
        if (num==0){
            System.out.println(Math.min(result,nArr.length));
            return;
        }else if (num==10){
            System.out.println(result);
            return;
        }
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        impasible = new boolean[10];
        for (int i : arr){
            impasible[i] = true;
        }
        sol(new int[nArr.length+1],0);
        sol(new int[nArr.length],0);
        sol(new int[nArr.length-1],0);
        System.out.println(result);
    }

    public static void sol(int[] output, int count){
        if (output.length==count){
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < output.length; i++) {
                s.append(output[i]);
            }
            if (s.length() > 0) {
                int total = output.length + Math.abs(Integer.parseInt(s.toString()) - n);
                result = Math.min(total, result);
            }
            return;
        }
        for(int i=0; i<10; i++){
            if (impasible[i]){
                continue;
            }
            output[count]=i;
            sol(output,count+1);
        }
    }
}
