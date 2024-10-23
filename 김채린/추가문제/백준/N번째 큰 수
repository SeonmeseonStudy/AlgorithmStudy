import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> a-b);
      for(int i=0; i<n; i++){
          int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
          for(int j=0; j<n; j++){
              q.add(a[j]);
          }
    }
      while (q.size()>n){
          q.poll();
      }
      System.out.println(q.poll());
    }
}
