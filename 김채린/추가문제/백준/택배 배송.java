import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[nums[0]];
        Arrays.fill(result, Integer.MAX_VALUE);
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for (int i = 0; i < nums[1]; i++) {
            int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            ArrayList<int[]> list = map.getOrDefault(now[0],new ArrayList<int[]>());
            list.add(new int[]{now[1],now[2]});
            map.put(now[0],list);
            ArrayList<int[]> list2 = map.getOrDefault(now[1],new ArrayList<int[]>());
            list2.add(new int[]{now[0],now[2]});
            map.put(now[1],list2);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        q.add(new int[]{1,0});
        result[0]=0;
        while (!q.isEmpty()){
            int[] nowNum = q.poll();
            if (nowNum[0]==nums[0]){
                System.out.println(nowNum[1]);
                return;
            }
            ArrayList<int[]> arrayList = map.getOrDefault(nowNum[0],new ArrayList<>());
            for(int i=0; i<arrayList.size(); i++){
                int[] nowArrNum = arrayList.get(i);
                if (result[nowArrNum[0]-1]>nowNum[1]+nowArrNum[1]){
                    result[nowArrNum[0]-1]=nowNum[1]+nowArrNum[1];
                    q.add(new int[]{nowArrNum[0], nowNum[1]+nowArrNum[1]});
                }
            }
        }
    }
}
