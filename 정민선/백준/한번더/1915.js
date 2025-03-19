const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n'); // 0, 'utf-8'
const [N, M] = input.shift().split(' ').map(Number);
let board = input.map(e => e.split('').map(Number));
let dp = Array.from({length: N}, () => Array(M).fill(0));

let size = 0;

for (let i=0; i<N; i++) {
    for (let j=0; j<M; j++) {
        if (board[i][j] === 0) continue;
        if (i === 0 || j === 0) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
        }
        size = Math.max(size, dp[i][j])
    }
}
console.log(size**2);