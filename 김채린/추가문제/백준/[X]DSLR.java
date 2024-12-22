import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 수

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt(); // 시작 값
            int b = sc.nextInt(); // 목표 값
            System.out.println(bfsDSLR(a, b));
        }
        sc.close();
    }

    private static String bfsDSLR(int a, int b) {
        boolean[] visited = new boolean[10000]; // 방문 여부 배열
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, ""));
        visited[a] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.value == b) {
                return current.commands; // 목표 값에 도달하면 명령어 반환
            }

            // D 연산
            int d = (current.value * 2) % 10000;
            if (!visited[d]) {
                visited[d] = true;
                queue.add(new Node(d, current.commands + "D"));
            }

            // S 연산
            int s = (current.value == 0) ? 9999 : current.value - 1;
            if (!visited[s]) {
                visited[s] = true;
                queue.add(new Node(s, current.commands + "S"));
            }

            // L 연산
            int l = (current.value % 1000) * 10 + (current.value / 1000);
            if (!visited[l]) {
                visited[l] = true;
                queue.add(new Node(l, current.commands + "L"));
            }

            // R 연산
            int r = (current.value % 10) * 1000 + (current.value / 10);
            if (!visited[r]) {
                visited[r] = true;
                queue.add(new Node(r, current.commands + "R"));
            }
        }

        return ""; // 도달할 수 없는 경우
    }

    // 상태를 표현하는 클래스
    static class Node {
        int value;
        String commands;

        public Node(int value, String commands) {
            this.value = value;
            this.commands = commands;
        }
    }
}
