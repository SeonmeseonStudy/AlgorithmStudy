class Solution {
    boolean solution(String s) {
        int result=0;
        s=s.toLowerCase();
        char[] chars = s.toCharArray();
        for (char alphabet:chars) {
            if (alphabet=='p'){
                result++;
            }else if(alphabet=='y'){
                result--;
            }
        }
        return result == 0;
    }
}
