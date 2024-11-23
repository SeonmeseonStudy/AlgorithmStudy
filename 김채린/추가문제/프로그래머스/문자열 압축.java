import java.util.*;
class Solution {
    static int length;
    static String nnnn;
    public int solution(String s) {
        length = s.length();
        int a = length/2;
        for(int i=0; i<a; i++){
            int index=0;
            String result="";
            while(index+i<s.length()){
                int count=1;
                String now = s.substring(index,index+i+1);
                index = index+i+1;
                while(index+i<s.length()&&now.equals(s.substring(index,index+i+1))){
                    index = index+i+1;
                    count++;
                }
                if(count>1){
                    result+=count;
                }
                result+=now;
            }
            if(index<s.length()){
                result+=s.substring(index);
            }
            length = Math.min(result.length(),length);
        }
        return length;
    }
}
