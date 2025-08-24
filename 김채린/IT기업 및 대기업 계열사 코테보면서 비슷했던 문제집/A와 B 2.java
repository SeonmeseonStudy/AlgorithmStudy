import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        Queue<String> queue = new LinkedList<>();
        queue.add(b);
        while (!queue.isEmpty()) {
            String now = queue.poll();
            if (now.length() == a.length()) {
                if (now.equals(a)) {
                    System.out.print(1);
                    return;
                }
                continue;
            }
            if (now.charAt(now.length() - 1) == 'A') {
                queue.add(now.substring(0, now.length() - 1));
            }
            if (now.charAt(0) == 'B') {
                StringBuilder sb = new StringBuilder();
                for (int i = now.length() - 1; i > 0; i--) {
                    sb.append(now.charAt(i));
                }
                queue.add(sb.toString());
            }
        }
        System.out.print(0);
    }
    }
