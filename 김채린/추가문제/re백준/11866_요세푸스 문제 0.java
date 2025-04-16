import java.util.*;
import java.io.*;
class Main{

    public static void main(String[] args) throws Exception {
        Buffereader br = new Buffereader(new InputStreamReader(System.in));
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queque<Integer> q = new LinkedList<>();
        for (int i=1; i<=n[0]; i++){
            q.add(i);
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (q.size()!=0){
            count++;
            if (count==n[1]){
                sb.append(q.poll()).append(", ");
                count =0;
            }
            int now = q.poll();
            q.add(now);
        }
        sb.append(">");
        System.out.print(sb);
    }
}
