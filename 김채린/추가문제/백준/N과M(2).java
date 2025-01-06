import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static StringBuilder result = new StringBuilder();
    private static void NAndM(int[] nums, int[] array, int n, int count) {
        if (count == nums[1]) {
            for (int i : array) {
                result.append(i).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = n; i <= nums[0]; i++) {
            array[count] = i;
            NAndM(nums, array,i+1,count+1);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array = new int[nums[1]];
        NAndM(nums, array,1, 0);
        System.out.println(result);
    }
}
