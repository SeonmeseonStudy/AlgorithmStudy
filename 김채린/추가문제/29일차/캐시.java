import java.util.*;
import java.math.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0){
            return cities.length * 5;
        }
        Queue<String> q = new LinkedList<>();
        int result = 0;
        for(String d : cities){
            d = d.toLowerCase();
            if (!q.contains(d)){
                result+=5;
                if (q.size()>=cacheSize){
                    q.poll();
                }
                q.add(d);
                continue;
            }
            result+=1;
            q.remove(d);
            q.add(d);
        }
        return result;
    }
}
