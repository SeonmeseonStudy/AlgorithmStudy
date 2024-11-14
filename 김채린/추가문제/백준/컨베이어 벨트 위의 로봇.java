import java.util.*;
import java.io.*;
class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> q1 = new LinkedList<>();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> robot= new ArrayList<>();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int result = 1;
        for (int i=nums[0]-1; i>=0; i-- ){
            q1.add(i);
        }
        int count=0;
        Queue<Integer> q2 = new LinkedList<>();
        for (int i=(nums[0]*2)-1; i>=nums[0]; i--){
            q2.add(i);
        }

        while(true){
            //1
            q2.add(q1.poll());
            int pre = q2.poll();
            q1.add(pre);

            //2
            int index =0;
            while (index<robot.size()){
                int a = robot.get(index);
                int out = q1.peek();
                if (out==a){
                    robot.remove(index);
                    continue;
                }
                int next = (a+1)% arr.length;
                if(arr[next]>0&&!robot.contains(next)){
                    arr[next]--;
                    if(arr[next]==0){
                        count++;
                    }
                    robot.remove(index);
                    if (out==next) {
                        continue;
                    }
                    robot.add(index, next);
                }
                index++;
            }

            //3
            if (arr[pre]>0){
                robot.add(pre);
                arr[pre]--;
                if (arr[pre]==0){
                    count++;
                }
            }

            //4
            if (count>=nums[1]){
                System.out.println(result);
                return;
            }
            result++;
        }
    }
}
