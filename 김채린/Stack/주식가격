//스택 사용 X
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        for(int i=0; i<prices.length;i++){
            for(int now=i+1; now<prices.length; now++){
                result[i]++;
                if(prices[i]>prices[now]){
                break;
            }
            }
        }
        return result;
    }
}
