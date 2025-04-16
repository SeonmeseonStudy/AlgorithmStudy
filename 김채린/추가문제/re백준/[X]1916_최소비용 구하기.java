import java.util.*;
import java.io.*;
class Main{
    static int n;
    static int m;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }
        for (int i = 0; i < m; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[temp[0] - 1][temp[1] - 1] = temp[2];
        }
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = target[0] - 1;
        int end = target[1] - 1;

        System.out.println(sol(start, end));
    }

    public static int sol(int start, int end) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int current = now[0];
            int currentDist = now[1];

            if (visited[current])
                continue;
            visited[current] = true;

            for (int i = 0; i < n; i++) {
                if (arr[current][i] != -1 && dist[i] > currentDist + arr[current][i]) {
                    dist[i] = currentDist + arr[current][i];
                    pq.add(new int[]{i, dist[i]});
                }
            }
        }
        return dist[end];
    }
}
