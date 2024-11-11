import java.util.*;
class Solution {
    static String result;

    public String solution(String new_id) {
        result = new_id;
        if(result.length()>0){
            one();
        }
        return result;
    }

    public void one() {
        result = result.toLowerCase();
        two();
    }

    public void two() {
        char[] chars = result.toCharArray();
        String s = "";
        for (int i = 0; i < result.length(); i++) {
            if (('a' <= chars[i] && 'z' >= chars[i]) || ('0' <= chars[i] && '9' >= chars[i]) || '_' == chars[i] || '-' == chars[i] || '.' == chars[i]) {
                s+=Character.toString(chars[i]);
            }
        }
        result=s;
        three();
    }

    public void three() {
        String copy = result.replace("..", ".");
        while (!result.equals(copy)) {
            result=copy;
            copy=result.replace("..", ".");
        }
        four();
    }
    public void four() {
        if(result.length()>0){
                if (result.charAt(0) == '.') {
                    result = result.substring(1);
                }
            }
            if (result.length() > 0) {
                if (result.charAt(result.length() - 1) == '.') {
                    result = result.substring(0, result.length() - 1);
                }
            }
            five();
        }

    public void five() {
        if(result.equals("")){
            result = "aaa";
            return;
        }
        six();
    }

    public void six() {
        if(result.length()>=16){
            int end = 15;
            while(true){
                if(result.charAt(end-1)=='.'){
                    end--;
                    continue;
                }
                break;
            }
            result = result.substring(0,end);
        }
        seven();
    }

    public void seven() {
        String c = Character.toString(result.charAt(result.length()-1));
        while(result.length()<3){
            result+=c;
        }
    }
}
