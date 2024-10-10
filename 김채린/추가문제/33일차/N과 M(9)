import java.io.*;
import java.util.*;

/*
LinkedHashSet이 아닌 TreeSet을 사용하면 안되는 이유

둘 다 정렬이 가능한 Set이라는 점은 동일하지만 LinkedHashSet은 입력순으로 정렬되고, TreeSet은 생성시 인자로 Comparator를 넘겨주지 않는다면 기본적으로 오름차순 정렬한다.
따라서, TreeSet을 사용하면 String을 기준으로 오름차순 정렬하기 때문에 기존에 숫자가 작은순으로 오름차순 정렬했던 순서가 깨지게 된다.
ex) "16", "135" → "135", "16"
*/


class Main {
    static int select;
    static int[] array;
    static Set<String> set = new LinkedHashSet<>();
    static int length;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        length = n[0];
        select = n[1];
        array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        visited = new boolean[length];
        Arrays.fill(visited, false);
        sol(0,new int[select]);
        for (String i:set){
            System.out.println(i);
        }
    }

    public static void sol(int count, int[] arr){
        if(count==select){
            StringBuilder sb = new StringBuilder();
            for (int i:arr){
                sb.append(i).append(' ');
            }
            set.add(sb.toString());
            return;
        }
        for(int i=0; i<length; i++){
            if (visited[i])
                continue;
                visited[i] = true;
                arr[count] = array[i];
                sol(count+1,arr);
                visited[i] = false;

        }
    }
}
