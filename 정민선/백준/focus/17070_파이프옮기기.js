const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");
const N = Number(input.shift());
let board = input.map(e => e.split(' ').map(Number));

let dp = Array.from({length : N}, () => Array.from({length : N}, () => Array(3).fill(0)));
dp[0][1][0] = 1

for (let i=0; i<N; i++) {  
    for (let j=1; j<N; j++) {
        if (board[i][j] === 1) continue;

        // 가로
        if (j > 0) {
            dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2]
        }
        // 세로
        if (i > 0) {
            dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2]
        }
        // 대각선
        if (i > 0 && j > 0 && board[i - 1][j] === 0 && board[i][j - 1] === 0){
            dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
        }
    }
}
console.log(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);