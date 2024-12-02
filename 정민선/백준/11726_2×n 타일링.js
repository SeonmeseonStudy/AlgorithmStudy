const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
const N = Number(input);

let dp = Array(N+1).fill(0);
dp[0] = 1;
dp[1] = 1; 
dp[2] = 2;

for (let i=3; i<=N; i++){
    dp[i] = (dp[i-1] + dp[i-2])%10007;
}
console.log(dp[N]);