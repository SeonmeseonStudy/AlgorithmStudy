import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[nums[0]];
        for(int i=0;i<nums[0]; i++){
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max =0;
        int count =0;
        int start =0;
        int i=0;
        while (i<nums[2]) {
            if (!list.contains(arr[i])) {
                count++;
            }
            list.add(arr[i]);
            i++;
        }
        int a = 1;
        if (list.contains(nums[3])) {
            a=0;
        }
        max = Math.max(max, count+a);
        int num =list.get(0);
        list.remove(0);
        if (!list.contains(num)){
            count--;
        }
        start++;
        while (start%nums[0]!=0){
            if (!list.contains(arr[i])) {
                count++;
            }
            list.add(arr[i]);
            i = (i+1)%nums[0];
            a = 1;
            if (list.contains(nums[3])) {
                a=0;
            }
            max = Math.max(max, count+a);
            num =list.get(0);
            list.remove(0);
            if (!list.contains(num)){
                count--;
            }
            start++;
        }
        System.out.println(max);
    }
}
