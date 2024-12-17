import java.util.*;
class Solution {
    static ArrayList<int[]> result = new ArrayList<>();
    public int[][] solution(int n) {
        sol(n,1,2,3);
        int[][] answer = new int[result.size()][2];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public void sol(int n, int start, int mid, int end){
        if (n==1){
            result.add(new int[]{start,end});
            return;
        }
        sol(n-1,start,end,mid);
        result.add(new int[]{start,end});
        sol(n-1,mid,start,end);
    }
}
