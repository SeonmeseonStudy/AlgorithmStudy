import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left=0;
        int right=1;
        int result =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(arr[0],1);
        int count=1;
        while(right<num[0]){
            int now = arr[right];
            int mapValue =map.getOrDefault(now,0)+1;
            if(mapValue>num[1]){
                result=Math.max(result,count);
                int leftNum =arr[left];
                while(leftNum!=now){
                    map.put(leftNum,map.get(leftNum)-1);
                    left++;
                    count--;
                    leftNum = arr[left];
                }
                left++;
                right++;
                continue;
            }
            map.put(now, mapValue);
            right++;
            count++;
        }
        if (result==0){
            System.out.println(count);
        }else {
            System.out.println(Math.max(result,count));
        }
    }
}
