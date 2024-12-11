const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim();
let N = Number(input);
let dp = Array.from({length : N+1}, () => undefined);
dp[0] = 0;
dp[1] = 0;

for (let i=2; i<=N; i++){
    dp[i] = dp[i-1] + 1;
    if (i%3 === 0){
        dp[i] = Math.min(dp[i], dp[i/3]+1);
    } 
    if (i%2 === 0){
        dp[i] = Math.min(dp[i], dp[i/2]+1);
    }
}
console.log(dp[N])