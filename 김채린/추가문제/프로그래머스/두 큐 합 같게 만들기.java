import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count =0;
        long q1Total = 0;
        long q2Total =0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++){
            long a = queue1[i];
            q1.add(a);
            q1Total+=a;
        }
        for(int i=0; i<queue2.length; i++){
            long a = queue2[i];
            q2.add(a);
            q2Total+=a;
        }
        while (q1Total!=q2Total||q1.isEmpty()||q2.isEmpty()){
            if (q1Total>q2Total){
                long now =q1.poll();
                q1Total-=now;
                q2Total+=now;
                q2.add(now);
            }else {
                long now =q2.poll();
                q2Total-=now;
                q1Total+=now;
                q1.add(now);
            }
            count++;
            if (count==queue1.length*2*2){
                return -1;
            }
        }
        return count;
    }
}
