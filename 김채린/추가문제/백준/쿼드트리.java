import java.io.*;
import java.util.*;
public class Main {
    static int num;
    static int[][] arr;
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        arr = new int[num][num];
        for(int i=0; i<num; i++){
            arr[i] =Arrays.stream(br.readLine().split("")).filter(it-> !it.equals("")).mapToInt(Integer::parseInt).toArray();
        }
        sol(0,0,num);
        System.out.println(sb.toString());
    }

    public static void sol(int y,int x, int size){
        if (size==1){
            sb.append(arr[y][x]);
            return;
        }
        boolean isSame = true;
        int origin = arr[y][x];
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if (origin!=arr[i][j]){
                    sb.append("(");
                    int newSize =size/2;
                    sol(y,x,newSize);
                    sol(y,x+newSize,newSize);
                    sol(y+newSize, x, newSize);
                    sol(y+newSize,x+newSize,newSize);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(origin);
    }
}
