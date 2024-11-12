import java.util.*;
import java.io.*;
class Solution {
    static int n2;
    static int[] info2;
    static int max =-1;
    static int[] resultList = new int[11];

    public int[] solution(int n, int[] info) {
        n2 = n;
        info2 = info;
        sol(0, new int[11],-1);
        if (max==-1){
            return new int[]{-1};
        }else {
            return resultList;
        }
    }

    public void sol(int count, int[] arr, int num) {
        if (count == n2) {
            int apeachNum = 0;
            int total = 0;
            for (int i = 0; i <= 10; i++) {
                if (arr[i] > 0) {
                    total += (10 - i);
                    continue;
                }
                if (info2[i] > 0) {
                    apeachNum += (10 - i);
                }}
            if (apeachNum < total) {
                if (max < total - apeachNum) {
                    max = total - apeachNum;
                    resultList = arr.clone();
                } else if (max == total - apeachNum) {
                    for (int i = 10; i >= 0; i--) {
                        if (resultList[i] < arr[i]) {
                            resultList = arr.clone();
                            break;
                        } else if (resultList[i] > arr[i]) {
                            break;
                        }
                    }
                }
            }
            return;
        }

        for (int i = num+1; i <= 10; i++) {
            if (arr[i]==0&&info2[i] < n2 - count) {
                arr[i] = info2[i] + 1;
                sol(count + info2[i] + 1, arr, i);
                arr[i] = 0;
            }
            if (i==10){
                arr[i] = n2-count;
                sol(n2, arr,i);
                arr[i]=0;
            }
        }
    }
}
