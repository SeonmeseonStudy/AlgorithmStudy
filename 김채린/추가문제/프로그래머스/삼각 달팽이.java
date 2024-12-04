class Solution {
    static int[][] arr;
    static int count =1;
    static int x=0;
    static int y=0;
    public int[] solution(int n) {
        if(n==1){
            return new int[]{1};
        }
        arr = new int[n][n];
        int[] answer = new int[(n*(n+1))/2];
        sol(n);
        int num =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[num] = arr[i][j];
                num++;
            }
        }
        return answer;
    }

    public void sol(int n){
        while(arr[y][x]==0){
            arr[y][x] = count;
            count++;
            if(y+1<n&&arr[y+1][x]==0){
                y++;
            }else{
                break;
            }
        }
        x++;
        while(arr[y][x]==0){
            arr[y][x] = count;
            count++;
            if(x+1<n&&arr[y][x+1]==0){
                x++;
            }else{
                break;
            }
        }
        x--;
        y--;
        while(arr[y][x]==0){
            arr[y][x] = count;
            count++;
            if(y-1>=0&&x-1>=0&&arr[y-1][x-1]==0){
                x--;
                y--;
            }else{
                break;
            }
        }
        y++;
        if(arr[y][x]==0){
            sol(n);
        }else{
            return;
        }
    }
}
