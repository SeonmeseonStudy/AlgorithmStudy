import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static  int[] num = new int[2];
    static int[][] arr;
    static int resultNum = Integer.MAX_VALUE;
    static boolean[] visited;
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        num[0] = sc.nextInt();
        num[1] = sc.nextInt();
        arr = new int[num[0]][num[0]];
        for (int i = 0; i < num[0]; i++) {
            for (int j=0; j<num[0]; j++){
                arr[i][j] = sc.nextInt();
                if (arr[i][j]==1){
                    home.add(new int[]{i,j});
                }else if(arr[i][j]==2){
                    chicken.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[chicken.size()];
        sol(new int[num[1]][2],0,0);
        System.out.println(resultNum);
    }

    public static void sol(int[][] result, int count,int afterNum){
        if (count==num[1]){
            sol2(result);
            return;
        }
        for(int i=afterNum; i<chicken.size(); i++) {
            if (!visited[i]) {
                int[] nowChicken = chicken.get(i);
                result[count] = new int[]{nowChicken[0], nowChicken[1]};
                visited[i] = true;
                sol(result, count + 1,i+1);
                visited[i] = false;
            }
        }
    }

    public static void sol2(int[][] result){
        int total=0;
        for(int i=0; i<home.size(); i++){
            int[] nowHome = home.get(i);
            int min = Integer.MAX_VALUE;
            for(int j=0; j<result.length; j++){
                min = Math.min(Math.abs(nowHome[0]-result[j][0])+Math.abs(nowHome[1]-result[j][1]),min);
            }
            total+=min;
        }
        resultNum = Math.min(resultNum,total);
    }
}
