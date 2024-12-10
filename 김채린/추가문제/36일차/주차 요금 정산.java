import java.util.*;
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] fees= {180, 5000, 10, 600};
        String[] a = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        s.solution(fees,a);
    }
    static int baseFee;
    static int baseTime;
    static int time;
    static int fee;
    public int[] solution(int[] fees, String[] records) {
        TreeMap<Integer, String[]> map = new TreeMap<>((a,b)-> {return a-b;});
        time = fees[2];
        baseTime = fees[0];
        baseFee = fees[1];
        fee=fees[3];
        for(int i=0; i<records.length; i++){
            String[] sArr =records[i].split(" ");
            int key = Integer.parseInt(sArr[1]);
            String[] nowCar = map.getOrDefault(key,new String[]{"0",sArr[0],"0"}); // key 출차여부, 입차 시간, 총합 시간
            if (sArr[2].equals("IN")){
                nowCar[0]="0";
                nowCar[1]=sArr[0];
            }else {
                nowCar[0] = "1";
                String inTime = nowCar[2];
                nowCar[2] = Integer.toString(Integer.parseInt(inTime) + sol(nowCar[1], sArr[0]));
            }
            map.put(key,nowCar);
        }
        int[] finalResult = new int[map.size()];
        int index =-1;
        for (int key: map.keySet()){
            index++;
            String[] nowArr = map.get(key);
            if (nowArr[0].equals("0")) {
                String inTime = nowArr[2];
                nowArr[2] = Integer.toString(Integer.parseInt(inTime) + sol(nowArr[1], "23:59"));
            }
            finalResult[index] = totalFee(Integer.parseInt(nowArr[2]));
        }
        return finalResult;
    }

    public int sol(String time, String out){
        int[] timeArr = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] outArr = Arrays.stream(out.split(":")).mapToInt(Integer::parseInt).toArray();
        int total =0;
        int minute = outArr[1]-timeArr[1];
        if (minute<0){
            total+=60+minute;
            timeArr[0]++;
        }else{
            total+=minute;
        }
        total+=(outArr[0]-timeArr[0])*60;
        return  total;
    }

    public int totalFee(int num){
        int total = baseFee;
        int num2= num-baseTime;
        int count =0;
        if (num2>0) {
            count = num2 / time;
            if (num2 % time > 0) {
                count++;
            }
        }
        return total+(count*fee);
    }
}
