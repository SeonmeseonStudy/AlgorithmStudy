import java.util.*;

public class Main {
    static int n;
    static String[][] map;
    static ArrayList<int[]> student = new ArrayList<>();
    static ArrayList<int[]> teacher = new ArrayList<>();
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static boolean result = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.next();
                if(map[i][j].equals("S")){
                    student.add(new int[]{i, j});
                }else if (map[i][j].equals("T")){
                    teacher.add(new int[]{i,j});
                }
            }
        }
        dfs(0);
        if (result){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }

    static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    dfs(wall + 1);
                    if (result){
                        return;
                    }
                    map[i][j] = "X";
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < teacher.size(); i++){
            int[] now = teacher.get(i);
            q.add(now);
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[1];
            int y = now[0];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                while(0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (map[ny][nx].equals("S")){
                        return;
                    }
                    if (map[ny][nx].equals("X")) {
                        nx += dx[k];
                        ny += dy[k];
                    }else{
                        break;
                    }
                }
            }
        }
        result = true;
    }
}
