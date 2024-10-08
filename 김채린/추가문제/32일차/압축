import java.util.*;
class Solution {
    public Integer[] solution(String msg) {
        char[] arr = msg.toCharArray();
        int length = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.add(String.valueOf(c));
        }
        int i = 0;
        int a = 1;
        while (i<length){
            String s = msg.substring(i, i+a);
            if (dictionary.contains(s)){
                if (i+a==length) {
                    result.add(dictionary.indexOf(s)+1);
                    i=i+a;
                }else{
                    a++;
                }
                }else {
                String s2 = msg.substring(i,i+a-1);
                result.add(dictionary.indexOf(s2)+1);
                i=i+a-1;
                a=1;
                dictionary.add(s);
            }
            }
        return result.toArray(new Integer[0]);
        }
}
