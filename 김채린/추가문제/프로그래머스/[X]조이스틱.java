import java.util.*;
//검색
class Solution {
    public int solution(String name) {
        int totalCount=0;
        int num = name.length();

        for(int i=0; i<name.length(); i++){
            totalCount+=Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
            int index =i+1;
            while(name.length()>index&&name.charAt(index)=='A'){
                index++;
            }
            num = Math.min(i*2+(name.length())-index,num);
            num = Math.min(((name.length())-index)*2+i, num);
        }
        return totalCount+num;
    }
}
