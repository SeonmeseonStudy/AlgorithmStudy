import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }else {
                return a[1]-b[1];
            }
        });
        for(int i=0; i<n; i++){
            q.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        int count=1;
        int end = q.poll()[1];
        while (!q.isEmpty()){
            int[] now = q.poll();
            if (now[0]>=end){
                count++;
                end = now[1];
            }
        }
    }
}
