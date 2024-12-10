import java.util.*;
class Solution {
    static int[] dy;
    static int[] dx;
    static boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        dy = new int[]{1,-1,0,0};
        dx = new int[]{0,0,1,-1};
        int maxSizeOfOneArea = 0;
        if(picture.length<1){
            return new int[]{picture.length,picture.length};
        }
        int numberOfArea = 0;
        visited = new boolean[m][n];
        int[] answer = new int[2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0&&!visited[i][j]){
                    numberOfArea++;
                    maxSizeOfOneArea=Math.max(sol(i,j,picture[i][j],m,n,picture),maxSizeOfOneArea);
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int sol(int y, int x, int num, int m, int n, int[][] picture){
        int total =0;
        for(int i=0; i<4; i++){
            int newY = y+dy[i];
            int newX = x+dx[i];
            if(newY>=0&&newY<m&&newX>=0&&newX<n&&!visited[newY][newX]&&picture[newY][newX]==num){
                visited[newY][newX]=true;
                total++;
                total+=sol(newY,newX,num,m,n,picture);
            }
        }
        return total;
    }
}
