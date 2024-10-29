import java.util.*;

class Solution {

    int[] dx ={1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int[][] arr;
    int index =1;
    int y;
    int x;
    int[][] land2;
    int count;
    public int solution(int[][] land) {
        y = land.length;
        x = land[0].length;
        land2=land;
        ArrayList<Integer> landCount = new ArrayList<>();

        arr = new int[y][x];
        for(int i=0; i<y; i++){
            for (int j=0; j<x; j++){
                if (land[i][j]==1&&arr[i][j]==0){
                    count=1;
                    arr[i][j]=index;
                    sol(j,i);
                    index++;
                    int count2 = count;
                    landCount.add(count2);
                }
            }
        }
        int max = 0;
        for(int i=0; i<x; i++){
            HashSet<Integer> set = new HashSet<>();
            for (int j=0; j<y;j++){
                if(arr[j][i]>0){
                    set.add(arr[j][i]);
                }
            }
            int total=0;
            for(int a:set){
                total+=landCount.get(a-1);
            }
            max=Math.max(total,max);
        }
        return max;
    }

    public void sol(int nowX, int nowY){
        for(int i=0; i<4; i++){
            int newX = nowX+dx[i];
            int newY = nowY+dy[i];
            if (newX>=0&&newY>=0&&newY<y&&newX<x&&land2[newY][newX]==1&&arr[newY][newX]==0){
                arr[newY][newX] = index;
                count++;
                sol(newX,newY);
            }
        }
    }
}
