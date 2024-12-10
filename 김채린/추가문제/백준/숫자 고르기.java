/*7
3
1
1
5
5
4
6*/
import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited,false);
        TreeSet<Integer> resultArr = new TreeSet<>((a,b)->a-b);
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
            if (i==arr[i]){
                resultArr.add(i);
                visited[i]=true;
            }
        }
        for (int i=1; i<=n; i++){
            if (!visited[i]){
                TreeSet<Integer> nowList = new TreeSet<>();
                int index = arr[i];
                nowList.add(i);
                visited[i]=true;
                boolean[] visited2 = visited.clone();
                while (!visited2[index]){
                    visited2[index] = true;
                    nowList.add(index);
                    index = arr[index];
                }
                if (index==i){
                    visited=visited2;
                    resultArr.addAll(nowList);
                }
            }
        }
        System.out.println(resultArr.size());
        for(int i : resultArr){
            System.out.println(i);
        }
    }
}
