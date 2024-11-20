import java.util.*;
class Solution {
    public long solution(int w, int h) {
        long num = sol(w,h);
        long total = (long)w*h;
        long newW= w/num;
        long newH = h/num;
        // 최대 공약수를 몇 번 반복했는지.
        long minus = num*(newW+newH-1);
        return total - minus;
    }
    //최대 공약수
    public long sol(long a, long b){
        if(b==0){
            return a;
        }
        return sol(b, a%b);
    }
}
