import java.io.*;

public class Main{
    static int N;
    static int[] arr;
    static int[] cal;
    static int result = 0;
    static boolean visited[];
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cal = new int[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        sol(0);
        System.out.println(result);
    }

    static void sol(int depth){
        if(depth==N){
            int sum = 0;
            for(int i=0;i<N-1;i++){
                sum += Math.abs(cal[i]-cal[i+1]);
            }
            result = Math.max(result, sum);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i]=true;
                cal[depth]=arr[i];
                sol(depth+1);
                visited[i]=false;
            }
        }
    }

}
