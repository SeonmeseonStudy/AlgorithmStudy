import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        Stack<Character> LStack = new Stack<>();
        Stack<Character> RStack= new Stack<>();
        for(char a: s){
            LStack.add(a);
        }
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String str = br.readLine();
        switch (str.charAt(0)) {
            case 'L':
                if (LStack.isEmpty()) {
                    break;
                }
                RStack.add(LStack.pop());
                break;
            case 'D':
                if (RStack.isEmpty()) {
                    break;
                }
                LStack.add(RStack.pop());
                break;
            case 'B':
                if (LStack.isEmpty()) {
                    break;
                }
                LStack.pop();
                break;
            case 'P':
                LStack.add(str.charAt(2));
        }}
        StringBuilder sb = new StringBuilder();
        while (!LStack.isEmpty()){
            RStack.add(LStack.pop());
        }
        while (!RStack.isEmpty()){
            sb.append(RStack.pop());
        }
        System.out.print(sb);
    }
}
