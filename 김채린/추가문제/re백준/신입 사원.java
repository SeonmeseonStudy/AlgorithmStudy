import java.util.*;
import java.io.*;
class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Interger.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0; j<a; j++){
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map.put(arr[0], arr[1]);
            }
            int cnt = 0;
            int min = map.get(1);
            for (int k=2; k<=a; k++){
                if (min > map.get(k)){
                    cnt++;
                    min = map.get(k);
                }
            }
            System.out.println(cnt);
            }
        }
    }
}
