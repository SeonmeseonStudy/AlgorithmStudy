import java.util.*;
import java.math.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> a = sol(str1);
        ArrayList<String> b = sol(str2);
        int count1 = 0;
        int count2 = a.size();
        for (int i=0; i<b.size(); i++){
            String now = b.get(i);
            if (a.contains(now)){
                count1++;
                a.remove(now);
            }else {
                count2++;
            }
        }
        if (count1==0){
            if(count2==0){
                return 65536;
            }
            return 0;
        }else {
        return (int)((count1*1.0/count2)*65536);}
        }

    public ArrayList<String> sol(String s){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i<s.length()-1; i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            if (!isSave(a) || !isSave(b)){
                continue;
            }
            list.add(s.substring(i,i+2).toLowerCase());
        }
        return list;
    }

    public boolean isSave(char c){
        return (c >= 'a'&& c <= 'z') || (c >= 'A'&&c<='Z');
    }
}
