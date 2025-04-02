import java.util.*;
import java.io.*;
class Main{
    static int[][] arr;
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new int[num][num];
        for (int i=0; i<num; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        for (int k=0; k<num; k++){
            for (int i=0; i<num; i++){
                for (int j=0; j<num; j++){
                    if (arr[i][k]==1 && arr[k][j]==1){
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for (int i=0; i<num; i++){
            for (int j=0; j<num; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
