import java.util.*;
import java.io.*;
import java.math.*;

class Main {
    static int end=1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a>=b) {
            System.out.println(a - b);
            return;
        }
        int[] visited = new int[end+1];
        Arrays.fill(visited,-1);
        Queue<Integer> q = new LinkedList<>();
        visited[a] = 0;
        q.add(a);
        while (!q.isEmpty()){
            int n = q.poll();
            for (int i:new int[]{n+1,n-1,n*2}){
                if (i>=0&&i<=end&&visited[i]==-1){
                    visited[i] = visited[n]+1;
                    q.add(i);
                    if (i==b){
                        System.out.println(visited[i]);
                        return;
                    }
                }
            }
        }
    }
}
