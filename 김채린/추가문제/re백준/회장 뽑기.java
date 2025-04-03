import java.util.*;
import java.io.*;
class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i=0; i<n; i++){
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }
        while (true){
            int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (now[0]==-1 && now[1]==-1){
                break;
            }
            arr[now[0]-1][now[1]-1]= arr[now[1]-1][now[0]-1] = 1;
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                for (int k=0; k<n; k++){
                    if (arr[j][i]==Integer.MAX_VALUE || arr[i][k]==Integer.MAX_VALUE){
                        continue;
                    }
                    if (arr[j][k]>arr[j][i]+arr[i][k]){
                        arr[j][k]=arr[j][i]+arr[i][k];
                    }
                }
            }
        }
        TreeSet<Integer> set = new TreeSet<>((a,b)->a-b);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            int max = 0;
            for (int j=0; j<n; j++){
                if (i==j|| arr[i][j]==Integer.MAX_VALUE){
                    continue;
                }
                if (arr[i][j]>max){
                    max = arr[i][j];
                }
            }
            if (min>max){
                set = new TreeSet<>((a,b)->a-b);
                set.add(i+1);
                min = max;
            }else if (min==max){
                set.add(i+1);
            }
        }

        System.out.println(min+" "+set.size());
        for (int i : set){
            System.out.print(i+" ");
        }
    }
}
