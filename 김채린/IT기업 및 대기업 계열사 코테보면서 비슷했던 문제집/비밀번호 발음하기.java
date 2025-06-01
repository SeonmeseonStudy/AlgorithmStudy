import java.io.*;
import java.util.Arrays;

public class Main {
    static char[] aeiou = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = br.readLine();
            if (s.equals("end")){
                break;
            }
            if(sol(s)){
                System.out.println("<"+s+"> is acceptable.");
            }else{
                System.out.println("<"+s+"> is not acceptable.");
            }
       }
    }

    public static boolean sol(String s){
        boolean isAeiou = false;
        int aCount = 0;
        int bCount = 0;
        char[] now =s.toCharArray();
        for(int i=0; i<now.length; i++){
            if (i!=0&&now[i]==now[i-1]&&now[i]!='e'&&now[i]!='o'){
                return false;
            }
            boolean isA = false;
            for(int j=0; j<aeiou.length; j++){
                if (now[i] == aeiou[j]){
                    aCount++;
                    bCount = 0;
                    isA = true;
                    isAeiou = true;
                    if (aCount>=3){
                        return false;
                    }
                    break;
                }
            }
            if (!isA){
                bCount++;
                aCount = 0;
                if (bCount>=3){
                    return false;
                }
            }
        }
        if (isAeiou){
            return true;
        }else{
            return false;
        }
    }
}
