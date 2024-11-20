import java.util.*;
import java.io.*;

class Main{
/*3 7
 32 62
 42 68
 12 98
 95 13
 97 25
 93 37
 79 27
 75 19
 49 47
 67 17*/
    public static void main(String[] args) {
        int[] result = new int[101];
        Scanner sc = new Scanner(System.in);
        int up = sc.nextInt();
        int down = sc.nextInt();
        HashMap<Integer, Integer> upMap = new HashMap<>();
        HashMap<Integer,Integer> downMap = new HashMap<>();
        for(int i=0; i<up; i++){
            upMap.put(sc.nextInt(), sc.nextInt());
        }
        for(int i=0; i<down; i++){
            downMap.put(sc.nextInt(), sc.nextInt());
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        while (!q.isEmpty()){
            int[] now=q.poll();
            for(int i=1; i<=6; i++) {
                int newNow = now[0] + i;
                if (newNow==100){
                    System.out.println(now[1]+1);
                    return;
                }
                if (newNow<100&&result[newNow] == 0) {
                    result[newNow] = now[1]+1;
                    if (downMap.get(newNow) == null) {
                        if (upMap.get(newNow) != null) {
                            q.add(new int[]{upMap.get(newNow), now[1] + 1});
                            result[upMap.get(newNow)] = now[1]+1;
                            continue;
                        }
                        q.add(new int[]{newNow, now[1] + 1});
                    } else {
                        q.add(new int[]{downMap.get(newNow), now[1] + 1});
                        result[downMap.get(newNow)] = now[1]+1;
                    }
                }
            }
        }
    }
}
