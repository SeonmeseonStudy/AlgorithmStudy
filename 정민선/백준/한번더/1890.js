// 숫자 범위 커서 BigInt써야함!!!

const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input.shift());
let board = input.map(e => e.split(' ').map(Number));
let dp = Array.from({ length: N }, () => Array(N).fill(0n));

dp[0][0] = 1n;
for (let i=0; i<N; i++) {
    for (let j=0; j<N; j++) {
        if (i === N-1 && j === N-1) continue;
        if (board[i][j] === 0) continue;

        let x = i + board[i][j];
        let y = j + board[i][j];
        

        if (N > x) dp[x][j] += dp[i][j];
        if (N > y) dp[i][y] += dp[i][j];
    }
}

console.log(dp[N-1][N-1].toString());