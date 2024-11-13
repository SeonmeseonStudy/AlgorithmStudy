import java.util.*;
import java.io.*;

class Main {
    static  ArrayList<String> charArrayList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        charArrayList = new ArrayList<>();
        for(int i=0; i<num; i++){
            String s = br.readLine();
            String[] sArr = s.split(" ");
            int index = -1;
            for (int j=0; j< sArr.length; j++) {
                if (sol(Character.toString(sArr[j].charAt(0)).toLowerCase())){
                    index=0;
                    for (int k=0; k<j;k++){
                        index+=sArr[k].length()+1;
                    }
                    break;
                }
            }
            if (index==-1) {
                for (int j = 1; j < s.length(); j++) {
                    if (sol(Character.toString(s.charAt(j)).toLowerCase())) {
                        index =j;
                        break;
                    }
                }
            }
            if (index==-1){
                System.out.println(s);
            }else {
                System.out.println(s.substring(0,index)+"["+s.substring(index,index+1)+"]"+s.substring(index+1));
            }
        }
    }

    public static boolean sol(String c){
        if (charArrayList.contains(c)|| c.equals(" ")){
            return false;
        }
        charArrayList.add(c);
        return true;
    }
}
