import java.util.*;

class Solution {
        public String[] solution(String[] files) {
        String[][] arr = new String[files.length][3];

        for (int i=0; i<files.length; i++){
            StringBuilder s = new StringBuilder();
            String a = files[i];
            int count=0;
        while (a.charAt(count)<'0'||a.charAt(count)>'9'){
            s.append(a.charAt(count));
            count++;
        }
        arr[i][0]=s.toString();
        s = new StringBuilder();
        while (count<a.length()&&a.charAt(count)>='0'&&a.charAt(count)<='9'){
            s.append(a.charAt(count));
            count++;
        }
        arr[i][1]=s.toString();
        arr[i][2]=a.substring(count);
        }
            Arrays.sort(arr, (a,b)-> {if(a[0].toLowerCase().equals(b[0].toLowerCase())){
               return Integer.parseInt(a[1])-Integer.parseInt(b[1]);
            }else {
                return  a[0].toLowerCase().compareTo(b[0].toLowerCase());
                }});
String[] result = new String[files.length];
        int index =0;
        for (String[] a:arr){
            result[index]=a[0]+a[1]+a[2];
            index++;
        }
            return result;
        }
    }
