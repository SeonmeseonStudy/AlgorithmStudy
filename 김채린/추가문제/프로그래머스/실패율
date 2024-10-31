import java.util.*;
import java.io.*;
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(5,new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N+2];
        int length = stages.length;
        int[] result = new int[N];
        for(int i=0; i<length; i++){
            arr[stages[i]]++;
        }
        PriorityQueue<double[]> q = new PriorityQueue<>((a,b)-> {if (a[1]==b[1]){
        return Double.compare(a[0],b[0]);}else {
            return Double.compare(b[1],a[1]);
        }
        });
        for(int i=N; i>0; i--){
            double now =arr[i];
            arr[i]+=arr[i+1];
            if(now==0){
                q.add(new double[]{i, 0});
                continue;
            }
            q.add(new double[]{i,now/(arr[i+1]+now)});
        }
        for(int i=0; i<N; i++){
            result[i] = (int)q.poll()[0];
        }
        return result;
    }
}
