import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int n=0; n<num; n++){
            sol(Integer.parseInt(br.readLine()),1,"1");
            System.out.println();
        }
    }

    public static void sol(int n, int count, String s){
        if (count==n){
            int index=0;
            String s2 = s.replace(" ","");
            Stack<Integer> stack = new Stack<>();
            while (index<s2.length()&&s2.charAt(index)!='+'&&s2.charAt(index)!='-'){
                index++;
            }
            stack.add(Integer.parseInt(s2.substring(0, index)));
            while (index<s2.length()){
                char c = s2.charAt(index);
                index++;
                int start = index;
                while (index<s2.length()&&s2.charAt(index)!='+'&&s2.charAt(index)!='-'){
                    index++;
                }
                int result=0;
                if (c=='+'){
                    result =  stack.pop()+Integer.parseInt(s2.substring(start, index));
                }else {
                    result =stack.pop()-Integer.parseInt(s2.substring(start, index));
                }
                stack.add(result);
            }
            if (stack.pop()==0){
                System.out.println(s);
            }
            return;
        }

        sol(n,count+1,s+" "+(count+1));
        sol(n,count+1,s+"+"+(count+1));
        sol(n,count+1,s+"-"+(count+1));
    }
}
