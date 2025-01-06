const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let rgb = input.map(e => e.split(' ').map(Number));

let dp = Array.from({length : N}, () => Array(3).fill(0));

dp[0][0] = rgb[0][0];
dp[0][1] = rgb[0][1];
dp[0][2] = rgb[0][2];

for (let i=1; i<N; i++) {
    dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
    dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
    dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
}

console.log(Math.min(...dp[N-1]));