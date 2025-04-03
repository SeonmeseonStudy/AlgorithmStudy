import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] arr = new char[nums[0]][nums[1]];
        for (int i = 0; i < nums[0]; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        long[] result = new long[26];
        for (int startY = 0; startY < nums[0]; startY++) {
            long col = (long) (startY + 1) * (2 * nums[0] - startY) + (long)(startY + nums[0] + 1) * (nums[0] - startY);
            for (int startX = 0; startX < nums[1] ; startX++) {
                long row = (long) (startX + 1) * (2 * nums[1] - startX) + (long) (startX + nums[1] + 1) * (nums[1] - startX);
                int index = arr[startY][startX] - 'A';
                result[index] += col * row;
            }
        }
        for (long i: result){
            System.out.println(i);
        }
    }
}
