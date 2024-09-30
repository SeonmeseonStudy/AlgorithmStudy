import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    int xMax;
    int yMax;
    public int solution(int[] mats, String[][] park) {
        xMax = park[0].length;
        yMax = park.length;
        Arrays.sort(mats);
        for(int i= mats.length-1; i>=0; i--){
            for(int j=0; j<=yMax-mats[i]; j++){
                for(int k=0; k<=xMax-mats[i]; k++){
                    if (sol(k,j,park,mats[i])){
                        return mats[i];
                    }
                }
            }
        }
        return -1;
    }

    public boolean sol(int x, int y, String[][] park, int n){
        for (int i=y; i<y+n; i++){
            for (int j=x; j<x+n; j++){
                if (!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;
    }
}
