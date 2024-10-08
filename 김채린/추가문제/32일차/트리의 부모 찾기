import java.util.*;
import java.io.*;
import java.math.*;
class Main {
static HashMap<Integer,ArrayList<Integer>> arr=new HashMap<>();
static int n;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=1; i<n; i++){
            int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(arr.get(a[0])==null){
                arr.put(a[0],new ArrayList<>());
            }
            arr.get(a[0]).add(a[1]);
            arr.computeIfAbsent(a[1],b->new ArrayList<>()).add(a[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        Boolean[] visited = new Boolean[n+1];
        Arrays.fill(visited, false);
        visited[1] = true;
        int[] result = new int[n+1];
        while (!q.isEmpty()){
            int a = q.poll();
            ArrayList<Integer> list = arr.get(a);
            for(int i:list){
                if (visited[i]){
                    continue;
                }
                visited[i]=true;
                result[i] = a;
                q.add(i);
            }
        }
        for(int i=2; i<=n; i++){
            System.out.println(result[i]);
        }
    }
}
