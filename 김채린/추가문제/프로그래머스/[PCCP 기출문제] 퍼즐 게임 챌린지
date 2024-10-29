
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level=1;
        int left =1;
        int result = 0;
        int right = 100000;
        while (left<=right) {
            long totalTime =times[0];
            level = (left+right)/2;
            for (int i = 1; i < diffs.length; i++) {
            if (diffs[i]<=level){
                totalTime +=times[i];
            }else {
                totalTime+=(times[i]+times[i-1])*(diffs[i]-level)+times[i];
            }
            if (totalTime>limit){
                break;
            }
            }
            if (totalTime<limit){
                result = level;
               right=level-1;
            }else if (totalTime==limit){
                return level;
            }else {
                left=level+1;
            }
        }
        return result;
    }
}
