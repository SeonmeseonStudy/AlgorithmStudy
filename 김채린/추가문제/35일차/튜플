import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] s2 = s.substring(2,s.length()-2).replace("},{"," ").split(" ");
        Arrays.sort(s2,(a,b)->a.length()-b.length());
        List<String> list = new ArrayList<>();
        int length = s2.length;
        for(int i=0; i<length;i++){
            for(String j:s2[i].split(",")){
                if(list.contains(j)){
                    continue;
                }
                list.add(j);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = Integer.parseInt(list.get(i);
        }
        return result;
    }
}
