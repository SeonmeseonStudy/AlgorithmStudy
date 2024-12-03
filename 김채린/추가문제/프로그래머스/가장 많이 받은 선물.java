import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[] result = new int[friends.length];
        int[][] arr = new int[friends.length][friends.length];
        HashMap<String, Integer> index = new HashMap<>();
        int[] giftCount = new int[friends.length];
        for(int i=0; i<friends.length; i++){
            index.put(friends[i],i);
        }
        for(int i=0; i<gifts.length; i++){
            String[] now = gifts[i].split(" ");
            int sender =index.get(now[0]);
            int recipient =index.get(now[1]);
            giftCount[sender]++;
            giftCount[recipient]--;
            arr[sender][recipient]++;
        }
        String aaaa = "";
        int maxCount = 0;
        for(int i=0; i<friends.length; i++){
            for(int j=i+1; j<friends.length; j++){
                int first = arr[i][j];
                int second = arr[j][i];
                if(first>second){
                    result[i]++;
                }else if(first<second){
                    result[j]++;
                }else{
                    first = giftCount[i];
                    second =giftCount[j];
                    if(first>second){
                        result[i]++;
                    }else if(first<second){
                        result[j]++;
                    }
                }
            }
            maxCount = Math.max(maxCount,result[i]);
        }
        return maxCount;
    }
}
