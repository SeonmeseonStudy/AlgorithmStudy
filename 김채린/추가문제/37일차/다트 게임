import java.util.*;

class Solution {

        public int solution(String dartResult) {
        int i=0;
        int now =0;
        int[] result = new int[3];
        while (now<dartResult.length()) {
            StringBuilder num = new StringBuilder();
            while (true){
                char s = dartResult.charAt(now);
                if (s<'0'||s>'9'){
                    break;
                }
                num.append(s);
                now++;
            }
            int a = Integer.parseInt(num.toString());
            char s = dartResult.charAt(now);
            switch (s){
                case 'D' :
                    a= (int)Math.pow(a,2);
                    break;
                case 'T':
                    a= (int)Math.pow(a,3);
                    break;
            }
            now++;
            if (now<dartResult.length()) {
                s = dartResult.charAt(now);
                if (s == '*') {
                    if (i > 0) {
                        result[i - 1] *= 2;
                    }
                    a *= 2;
                    now++;
                } else if (s == '#') {
                    a *= -1;
                    now++;
                }
            }
            result[i] = a;
            i++;
        }
        return result[0]+result[1]+result[2];
    }
}
