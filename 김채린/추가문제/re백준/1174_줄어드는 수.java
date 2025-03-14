import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Long> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(long i=0; i<=9; i++){
            arr.add(i);
            sol(i);
        }
        arr.sort(Comparator.naturalOrder());

        try {
            System.out.println(arr.get(n-1));
        }catch(Exception e){
            System.out.println(-1);
        }
    }

    public static void sol(long now){
        long num = now%10;
        for(int i=0; i<num; i++){
            long newN = now*10+i;
            arr.add(newN);
            sol(newN);
        }
    }
}
