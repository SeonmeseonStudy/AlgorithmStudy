import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            String commands = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String input = br.readLine().replace("[", "").replace("]", "");

            Deque<Integer> dq = new ArrayDeque<>();
            if (!input.isEmpty()) {
                for (String s : input.split(",")) {
                    dq.add(Integer.parseInt(s));
                }
            }
            boolean isR = false;
            boolean error = false;
            for (char cmd : commands.toCharArray()) {
                if (cmd == 'R') {
                    isR = !isR;
                } else {
                    if (dq.isEmpty()) {
                        System.out.println("error");
                        error = true;
                        break;
                    }
                    if (isR) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }

            if (!error) {
                StringBuilder result = new StringBuilder("[");
                while (!dq.isEmpty()) {
                    result.append(isR? dq.pollLast() : dq.pollFirst());
                    if (!dq.isEmpty()) result.append(",");
                }
                result.append("]");
                System.out.println(result);
            }
        }
    }
}
