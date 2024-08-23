import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        List<Integer> answer = new ArrayList<>();
        Deque<Integer[]> deq = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            deq.add(new Integer[]{i + 1, Integer.parseInt(nums[i])});
        }

        while (deq.size() > 0) {
            while (count != 0) {
                if (count > 0) {
                    count--;
                    deq.add(deq.pollFirst());
                } else {
                    count++;
                    deq.addFirst(deq.pollLast());
                }
            }

            Integer[] cur = deq.pollFirst();
            count = cur[1] > 0 ? cur[1] - 1 : cur[1];
            answer.add(cur[0]);
        }

        System.out.println(answer
        .stream()
        .map(Object::toString)
        .collect(Collectors.joining(" ")));
    }
}
