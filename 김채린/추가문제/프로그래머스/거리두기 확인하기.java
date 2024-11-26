import java.util.*;
class Solution {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    public int[] solution(String[][] places) {
        int[] result = new int[5];
        Arrays.fill(result,1);
        for(int i=0; i<5; i++){
            for(int a=0; a<5; a++){
                for(int b=0; b<5; b++){
                    if(places[i][a].charAt(b)==('P')){
                        if(sol(places[i],b,a)==0){
                            result[i]=0;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public int sol(String[] places, int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x,0});//[y,x,count]
        boolean[][] visited = new boolean[5][5];
        for(int i=0; i<5; i++){
            Arrays.fill(visited[i],false);
        }
        visited[y][x]=true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int l=0; l<4; l++){
                int newY= now[0]+dy[l];
                int newX= now[1]+dx[l];
                if(newX>=0&&newY>=0&&newY<5&&newX<5&&!visited[newY][newX]&&places[newY].charAt(newX)!='X'){
                    visited[newY][newX]=true;
                    if(places[newY].charAt(newX)=='P'){
                        return 0;
                    }
                    if(now[2]>0){
                        continue;
                    }
                    q.add(new int[]{newY,newX,1});
                }
            }
        }
        return 1;
    }
}
