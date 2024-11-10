import java.io.*;
// 브루트 포스(풀이 참고)
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int aCount=0;
        for (char c: arr){
            if (c=='a'){
                aCount++;
            }
        }
        int min = aCount;
        if (arr.length<=2||aCount== arr.length){
            min=0;
        }else {
            for(int i=0; i< arr.length; i++){
                int bCount =0;
                for(int j=i; j<aCount+i; j++){
                    if (arr[j% arr.length]=='b'){
                        bCount++;
                    }
                }
                min= Math.min(min,bCount);
            }}
        System.out.println(min);
    }
}
