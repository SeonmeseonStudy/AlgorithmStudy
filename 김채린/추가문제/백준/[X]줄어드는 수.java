import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] arr = {9,8,7,6,5,4,3,2,1,0};
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(0,0);
        list.sort((a,b)->a.compareTo(b));
        if (list.size()>=n) {
            System.out.println(list.get(n - 1));
        }else {
            System.out.println(-1);
        }
    }

    private static void dfs(long num, int index){
        if(!list.contains(num)){
            list.add(num);
        }
        if(index>=10){
            return;
        }
        dfs((num*10)+arr[index], index+1);
        dfs(num,index+1);
    }
}
