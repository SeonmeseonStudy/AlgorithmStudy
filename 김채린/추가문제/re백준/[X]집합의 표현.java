import java.util.*;
import java.io.*;
// 유니온 파인드 문제
class Main{
    static int n;
    static int m;
    static int[] map;
    static HashMap<Integer, Integer> score = new HashMap<>();
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n+1];
        for(int i=0; i<=n; i++) {
            map[i]=i;
        }
        for (int i=0; i<m; i++) {
            if (sc.nextInt() == 0) {
                sol1(sc.nextInt(), sc.nextInt());
            } else {
                if (sol2(sc.nextInt(), sc.nextInt())){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    public static void sol1(int a, int b){
        int scoreA = find(a);
        int scoreB = find(b);
        if (scoreA!=scoreB) {
            if (scoreA > scoreB) {
                map[scoreB] = scoreA;
            } else {
                map[scoreA] = scoreB;
            }
        }
    }

    public static boolean sol2(int a, int b){
        if (find(a)==find(b)){
            return true;
        }
        return false;
    }

    public static int find(int a){
        if(map[a]!=a){
            map[a] = find(map[a]);
        }
        return map[a];
    }
}
