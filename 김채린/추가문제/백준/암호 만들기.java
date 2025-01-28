import java.io.*;
import java.util.*;

public class Main {
    static String[] arr;
    static int[] n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = br.readLine().split(" ");
        Arrays.sort(arr);
        sol(new String[n[0]],0,-1,false,0);
    }

    public static void sol(String[] output, int count,int beforeIndex,boolean isInAEIOU,int otherCount){
        if (n[0]==count){
            if (!isInAEIOU||otherCount<2) return;
            String s = "";
            for(int i=0; i<n[0]; i++){
                s+=output[i];
            }
            System.out.println(s);
            return;
        }
        for(int i=beforeIndex+1; i<n[1]; i++){
            output[count]=arr[i];
            if (arr[i].equals("a")||arr[i].equals("e")||arr[i].equals("i")||arr[i].equals("o")||arr[i].equals("u")){
                sol(output, count+1, i,true,otherCount);
            }else {
                sol(output,count+1,i,isInAEIOU,otherCount+1);
            }
        }
    }
}
