class Solution {
    public int solution(int[][] triangle) {
        int high= triangle.length-1;
        for (int i= high-1; i>=0; i--){
            for (int j=0; j<i+1; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }
}
