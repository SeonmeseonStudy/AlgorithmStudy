import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String,String> map = new HashMap<>();
        List<Integer> action = new ArrayList<>();
        List<String> people = new ArrayList<>();
        for(String s: record) {
            String[] sArr = s.split(" ");
            if (sArr[0].equals("Leave")) {
                people.add(sArr[1]);
                action.add(1);
            } else {
                if (map.get(sArr[1]) != null) {
                    map.put(sArr[1], sArr[2]);
                } else {
                    map.remove(sArr[1]);
                    map.put(sArr[1], sArr[2]);
                }
                if (sArr[0].equals("Enter")) {
                    people.add(sArr[1]);
                    action.add(0);
                }
            }
        }
        String[] result = new String[action.size()];
        for (int i=0; i<action.size();i++){
            if (action.get(i)==0){
                result[i] = map.get(people.get(i))+"님이 들어왔습니다.";
            }else {
                result[i] = map.get(people.get(i))+"님이 나갔습니다.";
            }
        }
        return result;
    }
}
