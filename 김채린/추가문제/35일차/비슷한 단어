import java.io.*;
import java.util.*;
/*4
DOG
GOD
GOOD
DOLL*/
class Main{
    static char[] a;
    static int length;
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a =br.readLine().toCharArray();
        int[] alpha = new int[26];
        for(int i=0; i<a.length;i++){
            alpha[a[i]-'A']++;
        }
        int reuslt =0;
        length =a.length;
        for (int i=0; i<n-1; i++ ){
            int count =0;
            int[] alpha2 = alpha.clone();
            char[] b = br.readLine().toCharArray();
            for(int j=0; j<b.length; j++){
                if(alpha2[b[j]-'A']>0){
                    count++;
                    alpha2[b[j]-'A']--;
                }
            }
            if (length==b.length && (length==count||length-1==count)){
                reuslt++;
            } else if (length==b.length+1 && (length-1==count)) {
                reuslt++;
            }else if(length==b.length-1 && length==count){
                reuslt++;
            }
        }
        System.out.println(reuslt);
    }
}
