const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let numbers = input.map(Number);
let dp = Array.from({length : N+1}, () => Array(2).fill(0));

dp[0][0] = numbers[0];
dp[0][1] = numbers[0];
dp[1][0] = numbers[1];
dp[1][1] = dp[0][1] + numbers[1];

for (let i=2; i<N; i++){
    dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + numbers[i]; // 한칸 건너뜀
    dp[i][1] = dp[i-1][0] + numbers[i]; // 연속인 경우
}

console.log(Math.max(dp[N-1][0], dp[N-1][1]));