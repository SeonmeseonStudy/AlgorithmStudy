import java.io.*;
import java.util.*;
public class Main {
    // 일일히 다 구하지말고 길이구하고나서 세부적으로 구하기
    static int num;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        int nowNum = 0;
        int count=3;
        while (count<num) {
            nowNum++;
            count = (count*2)+(3+nowNum);
        }
        sol(count,nowNum);
    }

    public static void sol(int length, int nowNum){
        if (nowNum==0){
            if (num==1){
                System.out.println("m");
            }else {
                System.out.println("o");
            }
            return;
        }
        int mid = 3+nowNum;
        int pre = (length-mid)/2;
        if (num-pre>0&&num-pre<=mid){
            num-=pre;
            sol(0, 0);
        }else {
            if (num>pre) {
                num -= (pre + mid);
            }
            sol(pre,nowNum-1);
        }
    }
}
