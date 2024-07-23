import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        List list = new ArrayList<Integer>();
        for(int n:people) {
            list.add(n);
        }
        int count=0;
        list.sort(Comparator.reverseOrder());
        for (int i=0; i<list.size(); i++){
            int total = 0;
            total += (int) list.get(i);
            if (list.size()>1&&total+(int)list.get(list.size()-1)<=limit){
                list.remove(list.size()-1);
            }
            count++;
        }
        return count;
    }
}
