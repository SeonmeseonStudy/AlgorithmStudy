function solution(triangle) {
    // 각 위치까지 최대 합을 구하여 맨 마지막 값 중 제일 큰 값을 반환.
    let l = triangle.length;
    
    let sum = Array.from(Array(l), () => Array(l).fill(0));
    
    sum[0][0] = triangle[0][0];
    for (let i = 1; i < l; i++) {
        for (let j = 0; j < i + 1; j++) {
            sum[i][j] = triangle[i][j]
                + Math.max(sum[i - 1][j], sum[i - 1][j - 1] ? sum[i - 1][j - 1] : 0);
        }
    }
    
    return Math.max(...sum[l - 1]);
}