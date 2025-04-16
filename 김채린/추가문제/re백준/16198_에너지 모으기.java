import java.util.*;
import java.io.*;

class Main{
    static int result =0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> arrayList  = new ArrayList<>();
        for(int i=0; i<n; i++){
            arrayList.add(arr[i]);
        }
        sol(0,arrayList);
        System.out.print(result);
    }

    public static void sol(int total, ArrayList<Integer> arrayList){
        if (arrayList.size()==2){
            result = Math.max(total,result);
            return;
        }
        for(int i=1; i<arrayList.size()-1; i++){
            int now = arrayList.get(i);
            int plus = arrayList.get(i-1)*arrayList.get(i+1);
            arrayList.remove(i);
            sol(total+plus, arrayList);
            arrayList.add(i,now);
        }
    }
}
