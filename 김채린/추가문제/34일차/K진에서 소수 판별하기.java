//너무 어렵게 생각했지만 의외로 간단한 문제... 답지보고 머리를 탁! 쳤습니다...

import java.util.*;
import java.math.*;
class Solution {
    public int solution(int n, int k) {
    long[] s= Arrays.stream(Integer.toString(n,k).split("0")).filter(it->!it.equals("")).mapToLong(Long::parseLong).toArray();
        int count=0;
        for(long i:s){
            if(sol(i)){
                count++;
            }
        }
        return count;
    }

    public boolean sol(long n){
        if(n<2){
            return false;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
