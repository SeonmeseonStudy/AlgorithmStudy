import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] visited = new boolean[100001];
        Arrays.fill(visited,false);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{nums[0],0});
        while (!q.isEmpty()){
            int[] now = q.poll();
            if (now[0]==nums[1]){
                System.out.println(now[1]);
                return;
            }
            if (now[0] * 2<100001&&!visited[now[0]*2]) {
                visited[now[0] * 2] = true;
                q.add(new int[]{now[0] * 2, now[1]});
            }
            if (now[0] >0 && !visited[now[0]-1]) {
                visited[now[0]-1] = true;
                q.add(new int[]{now[0] - 1, now[1]+1});
            }
            if (now[0]+1<100001&&!visited[now[0]+1]) {
                visited[now[0]+1] = true;
                q.add(new int[]{now[0]+1,now[1]+1});
            }
        }
    }
}
