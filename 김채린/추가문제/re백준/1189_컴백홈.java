/*
3 4 6
....
.T..
....
    */
import java.util.*;
import java.io.*;

class Main {

    static int result = 0;
    static char[][] arr;
    static int[] nums;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = new char[nums[0]][nums[1]];
        for (int i = 0; i < nums[0]; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[nums[0]][nums[1]];
        visited[nums[0] - 1][0] = true;
        sol(nums[0] - 1, 0, 1, visited);
        System.out.println(result);
    }

    public static void sol(int y, int x, int count, boolean[][] visited) {
        if (count == nums[2]) {
            if (y == 0 && x == nums[1] - 1) {
                result++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newY >= 0 && newY < nums[0] && newX >= 0 && newX < nums[1] && !visited[newY][newX] && arr[newY][newX] != 'T') {
                visited[newY][newX] = true;
                sol(newY, newX, count + 1, visited);
                visited[newY][newX] = false;
            }
        }
    }
}
