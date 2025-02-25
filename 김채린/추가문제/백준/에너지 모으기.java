import java.io.*;
import java.util.*;

public class Main {
    static int num;
    static int max = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int[] nums =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0; i<num;i++){
            arr.add(nums[i]);
        }
        sol(arr,0);
        System.out.println(max);
    }

    public static void sol(ArrayList<Integer> arr, int total){
        if (arr.size()==2){
            max = Math.max(max,total);
            return;
        }
        for(int i=1; i<arr.size()-1; i++){
            ArrayList<Integer> newArr = new ArrayList<>();
            newArr.addAll(arr);
            int now= newArr.get(i-1)*newArr.get(i+1);
            newArr.remove(i);
            sol(newArr,total+now);
        }
    }
}
