import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        result = new int[num[0]+1];
        visited = new boolean[num[0]+1];
        for(int i=0; i<num[0]-1; i++){
            int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> arr =map.getOrDefault(now[0], new ArrayList<>());
            ArrayList<Integer> arr2 = map.getOrDefault(now[1], new ArrayList<>());
            arr.add(now[1]);
            arr2.add(now[0]);
            map.put(now[0], arr);
            map.put(now[1], arr2);
        }
        result = new int[num[0]+1];
        Arrays.fill(result,1);
        visited[num[1]] = true;
        sol(num[1]);
        for (int i=0; i<num[2]; i++){
            System.out.println(result[Integer.parseInt(br.readLine())]);
        }
    }

    public static void sol(int index){
        ArrayList<Integer> now = map.get(index);
        for(int i:now){
            if (!visited[i]){
                visited[i] = true;
                sol(i);
                result[index]+=result[i];
            }
        }
    }
}
