import java.util.*;
import java.io.*;

class Solution {
    static char[][] type = new char[][]{{'R','T'}, {'C','F'},{'J','M'},{'A','N'}};
    public String solution(String[] survey, int[] choices) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<survey.length; i++){
            char[] chars = survey[i].toCharArray();
            char key;
            if (choices[i]>4) {
                key = chars[1];
            }else if (choices[i]<4){
                key=chars[0];
            }else {
                continue;
            }
            map.put(key, map.getOrDefault(key, 0) + Math.abs(choices[i]-4));
        }
        String result ="";
        for (char[] c: type){
            int a=map.getOrDefault(c[0],0);
            int b=map.getOrDefault(c[1],0);
            if (a<b){
                result+=c[1];
            }else {
                result+=c[0];
            }
        }
        return result;
    }
}
