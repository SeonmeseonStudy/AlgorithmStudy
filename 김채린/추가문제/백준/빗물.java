import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int h =  sc.nextInt();
        int w = sc.nextInt();
        int[] arr = new int[w];
        int maxIndex=-1;
        int max =0;
        for(int i=0; i<w; i++){
            arr[i]=sc.nextInt();
            if (max<=arr[i]){
                max = arr[i];
                maxIndex=i;
            }
        }
        int index=0;
        max=0;
        int total=0;
        while (index<maxIndex){
            if (max<arr[index]){
                max=arr[index];
            }else if (max>arr[index]) {
                total+=max-arr[index];
            }
            index++;
        }
        index=w-1;
        max=0;
        while (index>maxIndex){
            if (max<arr[index]){
                max=arr[index];
            }else if (max>arr[index]){
                total+=max-arr[index];
            }
            index--;
        }
        System.out.println(total);
    }
}
