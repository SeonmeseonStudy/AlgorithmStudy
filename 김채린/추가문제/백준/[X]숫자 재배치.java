import java.io.*;
import java.util.*;

public class Main {
    static String[] num;
    static int[] number;
    static int max =0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num =  br.readLine().split(" ");
        number = new int[num[0].length()];
        for (int i=0; i<number.length; i++){
            number[i] = num[0].charAt(i)-'0';
        }
        boolean[] visited = new boolean[number.length];
        sol(0,visited,0);
        if(max!=0){
            System.out.println(max);
        }else {
            System.out.println(-1);
        }
    }

    public static void sol(int index, boolean[] visited, int nowNum){
        if (index==num[0].length()) {
            max = Math.max(max,nowNum);
            return;
        }
        for (int i= 0; i<number.length; i++){
            if (visited[i]||(index ==0&& number[i]==0)) {
                continue;
            }
            int newNum = (nowNum*10)+number[i];
            if (newNum>=Integer.parseInt(num[1])){
                continue;
            }
            visited[i] = true;
            sol(index+1,visited,newNum);
            visited[i] = false;
        }
    }
}
