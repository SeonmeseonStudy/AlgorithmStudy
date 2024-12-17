import java.util.*;
import java.io.*;
class Main{
    static int count=0;
    static int[][] arr;
    static int r;
    static int c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r=nums[1];
        c=nums[2];
        sol(0,0,(int)Math.pow(2,nums[0]));
    }

    public static void sol(int y, int x, int size){
        if(size==1){
            System.out.println(count);
            return;
        }
        int newSize = size/2;
        if (r<y+newSize&&c<x+newSize){
            sol(y, x, newSize);
        }else if (r<y+newSize&&c>=x+newSize){
            count+=(size*size)/4;
            sol(y,x+newSize,newSize);
        }else if (r>=y+newSize&&c<x+newSize){
            count+=((size*size)/4)*2;
            sol(y+newSize,x,newSize);
        }else if (r>=y+newSize&&c>=x+newSize){
            count+=((size*size)/4)*3;
            sol(y+newSize,x+newSize,newSize);
        }
    }
}
