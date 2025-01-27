import java.io.*;

public class Main {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new char[num][num];

        sol(false, 0,0,num);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num; i++){
            for (int j=0; j<num; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void sol(boolean blank, int y, int x, int size){

        if (blank){
            for(int i=y; i<y+size; i++){
                for(int j=x; j<x+size; j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (size==1){
            arr[y][x]='*';
            return;
        }

        int count=0;
        int newSize = size/3;
        for (int i=y; i<y+size; i+=newSize){
            for (int j=x; j<x+size; j+=newSize){
                if (count==4){
                    sol(true,i,j,newSize);
                }else {
                    sol(false,i,j,newSize);
                }
                count++;
            }
        }
    }
}
