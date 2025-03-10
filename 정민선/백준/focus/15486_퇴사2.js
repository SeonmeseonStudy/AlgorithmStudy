const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let N = Number(input[0]);

let dp = Array(N+2).fill(0);

for (let i=1; i<=N; i++) {
    let [t, p] = input[i].split(' ').map(Number);
    
    dp[i] = Math.max(dp[i], dp[i-1]);
    if (i+t <= N+1) {
        dp[i+t] = Math.max(dp[i+t], dp[i]+p);
    }
}
console.log(Math.max(...dp));