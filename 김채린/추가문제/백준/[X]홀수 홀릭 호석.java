import java.util.*;
import java.io.*;
// 답지보고서 풀음
public class Main {
    static int max=0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        sol(nums,countResult(Integer.parseInt(nums)));
        System.out.println(min +" "+max);
    }

    public static void sol(String n, int count ){
        if (n.length()==1){
            max = Math.max(max,count);
            min = Math.min(min,count);
        }else if (n.length()==2){
            String s1 = n.substring(0,1);
            String s2 =n.substring(1);
            int total = Integer.parseInt(s1)+Integer.parseInt(s2);
            sol(Integer.toString(total), count+countResult(total));
        }else {
            for(int i =0; i<n.length()-2; i++){
                for (int j=i+1; j<n.length()-1; j++){
                    String s1 = n.substring(0,i+1);
                    String s2 = n.substring(i+1,j+1);
                    String s3 = n.substring(j+1);
                    int total = Integer.parseInt(s1)+Integer.parseInt(s2)+Integer.parseInt(s3);
                    sol(Integer.toString(total), count+countResult(total));
                }
            }
        }
    }

    public static int countResult(int num){
        int count =0;
        while (num>0){
            if ((num%10)%2 == 1){
                count++;
            }
            num/=10;
        }
        return count;
    }
}
