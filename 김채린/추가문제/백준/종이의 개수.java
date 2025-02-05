import java.io.*;
import java.util.*;
public class Main {
    static int num;
    static int zero =0;
    static int mOne = 0;
    static int pOne =0;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        arr = new int[num][num];
        for (int i=0; i<num; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        sol(num,0,0);
        System.out.println(mOne+"\n"+zero+"\n"+pOne);
    }

    public static void sol(int size, int y, int x){
        if (size==1){
            for(int i=y; i<y+size; i++){
                for(int j=x; j<x+size; j++){
                    count(arr[i][j]);
                }
            }
            return;
        }
        int now = arr[y][x];
        for (int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if (now!=arr[i][j]){
                    int newSize = size/3;
                    for (int l=y; l<y+size; l+=newSize) {
                        for (int k=x; k<x+size; k+=newSize) {
                            sol(newSize, l, k);
                        }
                    }
                    return;
                }
            }
        }
        count(now);
    }

    public static void count(int num){
        if (num==0){
            zero++;
        }else if(num==-1){
            mOne++;
        }else {
            pOne++;
        }
    }

}
