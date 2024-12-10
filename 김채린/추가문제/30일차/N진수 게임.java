import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) throws Exception {
        int count=0;
        int a = 0;
        int turn = 1;
        StringBuilder s = new StringBuilder();
        while (count<t){
            String now = Integer.toString(a,n).toUpperCase();
            for(int i=0; i<now.length();i++){
                if (turn==p){
                    s.append(now.charAt(i));
                    count++;
                    if (count==t){
                        break;
                    }
                }
                turn = turn%m+1;
            }
            a++;}
        return s.toString();
    }
}
