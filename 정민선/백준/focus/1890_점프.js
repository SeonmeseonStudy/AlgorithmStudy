const fs = require("fs");
let input = fs
    .readFileSync("./정민선/백준/input.txt")
    .toString()
    .trim()
    .split("\n");

const N = Number(input.shift());
let board = input.map((e) => e.split(" ").map(Number));
let dp = Array.from({ length: N }, () => Array(N).fill(0n));
dp[0][0] = 1n;

for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
        if (i === N - 1 && j === N - 1) continue;

        let jump = BigInt(board[i][j]);
        if (jump === 0n) continue;

        let x = i + Number(jump);
        let y = j + Number(jump);
        
        if (x < N) dp[x][j] += dp[i][j];
        if (y < N) dp[i][y] += dp[i][j];
    }
}

console.log(dp[N - 1][N - 1].toString());
