class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n][m];
        arr[0][0]=1;
        for (int[] i : puddles){
            arr[i[1]-1][i[0]-1] = -1;
        }
        for (int i=0; i<n; i++) {
            for (int j= 0; j<m; j++) {
                if (arr[i][j] == 0) {
                    int sum =0;
                    if (i - 1 >= 0 && arr[i - 1][j] != -1)
                        sum += arr[i - 1][j];
                    if (j - 1 >= 0 && arr[i][j - 1] != -1)
                        sum+= arr[i][j - 1];
                    arr[i][j] =sum%1000000007;
                }
            }
        }
        return arr[n - 1][m - 1];
    }
}
