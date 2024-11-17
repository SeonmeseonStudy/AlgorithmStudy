import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        ArrayList<String[]> result = new ArrayList<>();
        String m2 = sol(m);
        for(int i=0; i< musicinfos.length; i++){
            String[] arr = musicinfos[i].split(",");
            int[] start = Arrays.stream(arr[0].split(":")).mapToInt(Integer::parseInt).toArray();
            int[] end=Arrays.stream(arr[1].split(":")).mapToInt(Integer::parseInt).toArray();
            int time2 = end[0]*60+end[1]- (start[0]*60+start[1]);
            int time= time2;
            String newString = sol(arr[3]);
            String s ="";
            while (time>0){
                if (time>=newString.length()){
                    s+=newString;
                    time-=newString.length();
                    continue;
                }
                s+=newString.substring(0,time);
                time=0;
            }
            if (s.contains(m2)){
                result.add(new String[]{arr[2],Integer.toString(time2)});
            }
        }
        if (result.isEmpty()){
            return "(None)";
        }else {
            result.sort((a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
            return result.get(0)[0];
        }
    }

    public String sol(String s){
        return s.replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a").replace("B#","b");
    }
}
