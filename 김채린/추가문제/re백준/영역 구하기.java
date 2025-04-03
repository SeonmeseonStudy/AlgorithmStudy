import java.util.*;
import java.io.*;
class Main{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] arr;
    static int size;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = new boolean[num[0]][num[1]];
        for (int i = 0; i < num[2]; i++) {
            int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = now[0]; j < now[2]; j++) {
                for (int k = now[1]; k <now[3]; k++) {
                    if (arr[num[0]-1-k][j]){
                        continue;
                    }
                    arr[num[0]-1-k][j] = true;
                }
            }
        }
        for (int i=0; i<num[0]; i++){
            for (int j=0; j<num[1]; j++){
                if (!arr[i][j]){
                    size = 1;
                    arr[i][j] = true;
                    sol(i,j);
                    list.add(size);
                }
            }
        }
        System.out.println(list.size());
        list.sort((a, b) -> a - b);
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    public static void sol(int y, int x){
        for (int i=0; i<4; i++){
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newY>=0 && newY< arr.length && newX>=0 && newX<arr[0].length){
                if (!arr[newY][newX]){
                    size++;
                    arr[newY][newX] = true;
                    sol(newY, newX);
                }
            }
        }
    }
}
