import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        Queue<String> q = new LinkedList<>();
        q.add(t);
        while (!q.isEmpty()) {
            String now = q.poll();
            if (now.length() == s.length()) {
                if (now.equals(s)) {
                    System.out.println(1);
                    return;
                }
                continue;
            }
            String newNow;
            if (now.charAt(0) == 'B') {
                newNow = now.substring(1);
                String newString = "";
                for (int i = newNow.length() - 1; i >= 0; i--) {
                    newString += newNow.charAt(i);
                }
                newNow = newString;
                q.add(newNow);
            }
            if (now.charAt(now.length() - 1) == 'A') {
                newNow = now.substring(0, now.length() - 1);
                q.add(newNow);
            }
        }
        System.out.println(0);
    }
}
