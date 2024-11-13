import java.util.*;
class Solution {
    int clear;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long reuslt =0;
        int deliverPointer=n-1;
        int pickupsPointer = n-1;
        clear=deliveries.length;
        while(clear>0){
            if (deliveries[clear-1]==0&&pickups[clear-1]==0){
                clear--;
                continue;
            }
            reuslt+=clear*2;
            int deliver = cap;
            int pickup =cap;
            while (deliverPointer>=0&&deliver>=0){
                int a = deliveries[deliverPointer];
                if(deliveries[deliverPointer]<deliver){
                    deliver-=deliveries[deliverPointer];
                    deliveries[deliverPointer]=0;
                    deliverPointer--;
                } else if (a==deliver) {
                    deliveries[deliverPointer]=0;
                    break;
                } else{
                    deliveries[deliverPointer]-=deliver;
                    break;
                }
            }
            while (pickupsPointer>=0&&pickup>=0){
                int a =pickups[pickupsPointer];
                if(a<pickup){
                    pickup-=pickups[pickupsPointer];
                    pickups[pickupsPointer]=0;
                    pickupsPointer--;
                } else if (a==pickup) {
                    pickups[pickupsPointer]=0;
                    break;
                } else{
                    pickups[pickupsPointer]-=pickup;
                    break;
                }
            }
        }
        return reuslt;
    }
}
