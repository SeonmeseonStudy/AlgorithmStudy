import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] resultArr = new String[n];
        for(int i=0; i<n; i++){
            String a1 = Integer.toString(arr1[i],2);
            String s1 ="";
            for(int j=0; j<n-a1.length(); j++){
                s1+="0";
            }
            s1+=a1;
            String a2 = Integer.toString(arr2[i],2);
            String s2 ="";
            for(int j=0; j<n-a2.length(); j++){
                s2+="0";
            }
            s2+=a2;
            String result = "";
            for(int j=0; j<n; j++){
                if(s1.charAt(j)=='1'||s2.charAt(j)=='1'){
                    result+="#";
                    continue;
                }
                result+=" ";
            }
            resultArr[i] = result;
        }
        return resultArr;
    }
}
