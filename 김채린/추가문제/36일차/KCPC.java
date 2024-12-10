import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){//0 - 팀갯수 1: 문제 객수 2: 팀 ID 3:로그갯
            int[] condition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] totalScore = new int[condition[0]+1];
            int[][] score = new int[condition[0]+1][condition[1]+1];
            int[] count = new int[condition[0]+1];
            int[] speed = new int[condition[0]+1];
            int speedCount = 1;
            for (int j=0; j<condition[3]; j++){
                int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (score[now[0]][now[1]] < now[2]){
                   totalScore[now[0]]+=  now[2] - score[now[0]][now[1]];
                    score[now[0]][now[1]] = now[2];
                }
                count[now[0]]++;
                speed[now[0]]=speedCount;
                speedCount++;
            }
            int rank = 1;
            int a = condition[2];
            for (int j=1; j<=condition[0]; j++) {
                if (a==j){
                    continue;
                }
                if (totalScore[j] > totalScore[a]) {
                    rank++;
                } else if (totalScore[j] == totalScore[a]) {
                    if (count[j] == count[a]) {
                        if (speed[j] < speed[a]) {
                            rank++;
                        }
                    } else if (count[j] < count[a]) {
                        rank++;
                    }
                }
            }
            System.out.println(rank);
        }
    }
}
