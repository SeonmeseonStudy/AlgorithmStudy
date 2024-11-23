import java.util.*;
import java.io.*;

class Main{
    /*
    2
    superaquatornado
    2
    abcdefghijklmnopqrstuvwxyz
    5
    */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num =Integer.parseInt(br.readLine());
        for(int i=0; i< num; i++){
            int shortNum = Integer.MAX_VALUE;
            int longNum= Integer.MIN_VALUE;
            char[] charArr = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            if (n==1){
                System.out.println("1 1");
                continue;
            }
            LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
            for(int j=0; j<charArr.length; j++) {
                map.put(charArr[j], map.getOrDefault(charArr[j],0)+1);
            }
            for(int j=0; j<charArr.length; j++) {
                if (map.get(charArr[j])>=n){
                    int count=1;
                    for(int l= j+1; l<charArr.length; l++){
                        if(charArr[j]==charArr[l]){
                            count++;
                        }
                        if (count==n){
                            shortNum = Math.min(shortNum,l-j+1);
                            longNum=Math.max(longNum,l-j+1);
                            break;
                        }
                    }
                }
            }
            if (longNum==Integer.MIN_VALUE&&shortNum==Integer.MAX_VALUE){
                System.out.println(-1);
            }else {
                System.out.println(shortNum+" "+longNum);
            }
        }
    }
}
