import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("100-200*300-500+20"));

    }
    long max =Integer.MIN_VALUE;
    ArrayList<Character> oper = new ArrayList<>();
    public long solution(String expression) {
        ArrayList<Character> operList = new ArrayList<>();
        ArrayList<Long> numList =new ArrayList<>();
        String num = "";
        for(int i=0; i< expression.length(); i++){
            char c = expression.charAt(i);
            if (c<'0'||c>'9'){
                numList.add(Long.parseLong(num));
                num = "";
                operList.add(c);
                if (!oper.contains(c)){
                    oper.add(c);
                }
                continue;
            }
            num+=Character.toString(c);
        }
        numList.add(Long.parseLong(num));
        boolean[] visited = new boolean[oper.size()];
        Arrays.fill(visited, false);
        sol(visited, operList,numList);
        return max;
    }

    public void sol(boolean[] visited,ArrayList<Character> operList,ArrayList<Long> numList ){
        if (numList.size()<2){
            max = Math.max(Math.abs(numList.get(0)), max);
            return;
        }
        for (int i=0; i<visited.length; i++){
            if (!visited[i]){
                visited[i]= true;
                char c = oper.get(i);
                ArrayList<Long> newNumList = new ArrayList<>(numList);
                ArrayList<Character> newOperList = new ArrayList<>(operList);
                int j=0;
                while (j<newOperList.size()){
                    if (newOperList.get(j)==c){
                        long a = newNumList.get(j);
                        long b = newNumList.get(j+1);
                        newOperList.remove(j);
                        newNumList.remove(j);
                        newNumList.remove(j);
                        newNumList.add(j,cal(c, a,b));
                        continue;
                    }
                    j++;
                }
                sol(visited, newOperList, newNumList);
                visited[i]=false;
            }
        }
    }

    public long cal(char a,long num1, long num2){
        if (a=='+'){
            return num1+num2;
        }else if(a=='-'){
            return num1-num2;
        }else {
            return num1*num2;
        }
    }
}
