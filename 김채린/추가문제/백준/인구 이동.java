import java.io.*;
import java.util.*;
public class Main {
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static ArrayList<int[]> totalArr;
    static boolean[][] visited;
    static int total;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[nums[0]][nums[0]];
        int result = 0;
        for (int i = 0; i < nums[0]; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        boolean change = true;
        while (change) {
            change = false;
            visited = new boolean[nums[0]][nums[0]];
            for (int i = 0; i < nums[0]; i++) {
                for (int j = 0; j < nums[0]; j++) {
                    if (!visited[i][j]) {
                        totalArr = new ArrayList<>();
                        total = 0;
                        sol(nums, arr, i, j);
                        if (!totalArr.isEmpty()) {
                            change = true;
                            int value = 0;
                            if (total > 0) {
                                value = total / totalArr.size();
                            }
                            for (int k = 0; k < totalArr.size(); k++) {
                                int[] now = totalArr.get(k);
                                arr[now[0]][now[1]] = value;
                            }
                        }
                    }
                }
            }
            if (change) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static void sol(int[] nums, int[][] arr, int y, int x){
        Queue <int[] > q = new LinkedList<>();
        q.add(new int[]{y,x});
        while (!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int newY = now[0]+dy[i];
                int newX = now[1]+dx[i];
                if (newX>=0&&newX<nums[0]&&newY>=0&&newY<nums[0]&&!visited[newY][newX]
                    &&Math.abs(arr[newY][newX]-arr[now[0]][now[1]])>=nums[1]&&Math.abs(arr[newY][newX]-arr[now[0]][now[1]])<=nums[2]){
                    visited[newY][newX] = true;
                    total+=arr[newY][newX];
                    totalArr.add(new int[]{newY,newX});
                    q.add(new int[]{newY,newX});
                }
            }
        }
    }
}
