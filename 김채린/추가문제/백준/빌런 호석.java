import java.util.*;
import java.io.*;

class Main{
    static int[][] digital= new int[][]{{0,1,1,1,1,1,1},{0,0,0,1,1,0,0},{1,0,1,1,0,1,1},{1,0,1,1,1,1,0},{1,1,0,1,1,0,0},{1,1,1,0,1,1,0},{1,1,1,0,1,1,1},{0,0,1,1,1,0,0},{1,1,1,1,1,1,1},{1,1,1,1,1,1,0}};
    static int totalCount=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N이하
        int K = sc.nextInt(); //자리수
        int P = sc.nextInt();//변경횟수
        int X = sc.nextInt();//본래 값
        int[] XArr = new int[K];
        for (int i=K-1; i>=0; i--){
            XArr[K-1-i] =(int)(X/Math.pow(10.0,i));
            X%=Math.pow(10,i);
        }
        sol(new int[K],0,K,N,XArr,P,P);
        System.out.println(totalCount);
    }

    public static void sol(int[] result,int count,int K, int N,int[] X, int P, int originalP){
        if (count==K){
            String s ="";
            for(int i:result){
                s+=i;
            }
            if (Integer.parseInt(s)<=N&&P<originalP&&Integer.parseInt(s)!=0){
                totalCount++;
            }
            return;
        }
        for (int i=0; i<=9; i++){
            int change=0;
            if (X[count]!=i){
                for (int j=0; j<7; j++){
                    if (change>P){
                        break;
                    }
                    if(digital[X[count]][j]==digital[i][j]){
                        continue;
                    }
                    change++;
                }
            }
            if (change<=P){
                result[count] = i;
                sol(result,count+1,K,N,X,P-change,originalP);
            }
        }
    }
}
