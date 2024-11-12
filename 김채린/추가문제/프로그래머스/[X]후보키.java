import java.util.*;

class Solution {
    ArrayList<String> result = new ArrayList<>();
    public int solution(String[][] relation) {
        for(int i=1; i <= relation.length; i++){
            sol(0,new int[i], i,new boolean[relation[0].length],relation);
        }
        return result.size();
    }

    public void sol(int count, int[] arr, int depth, boolean[] visited, String[][] relation) {
        if (count == depth) {
            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i< relation.length; i++) {
                String s="";
                for (int a : arr) {
                    s+=relation[i][a];
                }
                if (list.contains(s)){
                    return;
                }
                list.add(s);
            }

            for (String num: result) {
                int minimalism = 0;
                for (int a : arr) {
                    if (num.contains(Integer.toString(a))) {
                        minimalism++;
                    }
                }
                if (minimalism == num.length()) {
                    return;
                }
            }
            String arrString = "";
            for(int a: arr){
                arrString+=a;
            }
            result.add(arrString);
            return;
        }
        for (int i = 0; i < relation[0].length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[count] = i;
                sol(count+1 , arr, depth, visited, relation);
                visited[i] = false;
            }
        }
    }
}
