import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int now = -1;
        List<Integer> result = new ArrayList();
        for(int n:arr){
            if(now!=n){
                result.add(n);
                now = n;
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}

-------스택 사용--------
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack s = new Stack<Integer>();
        for(int n :arr){
            if(s.isEmpty()||(int)s.peek()!=n){
                s.push(n);
            }
        }
        return s.stream().mapToInt(i->(int)i).toArray();
    }
}
