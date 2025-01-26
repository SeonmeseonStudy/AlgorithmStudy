import java.util.*;
class Main{
    static int[] dy = {1,1,-1,-1,2,2,-2,-2};
    static int[] dx ={2,-2,2,-2,1,-1,1,-1};
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int a=0; a<num; a++){
            int n = sc.nextInt();
            int nowY = sc.nextInt();
            int nowX = sc.nextInt();
            int targetY = sc.nextInt();
            int targetX = sc.nextInt();
            if (targetY==nowY&&targetX==nowX){
                System.out.println(0);
                continue;
            }
            boolean find = false;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{nowY,nowX,0});
            boolean[][] visited = new boolean[n][n];
            visited[nowY][nowX] =true;
            while(!find){
                int[] now = q.poll();
                for(int i=0; i<dy.length; i++){
                    int newY = now[0]+dy[i];
                    int newX = now[1]+dx[i];
                    int count=now[2];
                    if(newY>=0&&newY<n&&newX>=0&&newX<n&&!visited[newY][newX]){
                        if(newY==targetY&&newX==targetX){
                            System.out.println(count+1);
                            find = true;
                        }else {
                            visited[newY][newX] = true;
                            q.add(new int[]{newY,newX,count+1});
                        }
                    }
                }
            }
        }
    }
}
