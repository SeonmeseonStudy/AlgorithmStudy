const fs = require('fs');
const [A, B] = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const N = A.length;
const M = B.length;
let dp = Array.from({length: N+1}, () => Array(M+1).fill(0));

for (let i=1; i<N+1; i++){
    for (let j=1; j<M+1; j++){
        if (A[i-1] === B[j-1]) {
            dp[i][j] = dp[i-1][j-1] + 1;
        } else {
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
    }
}

console.log(Math.max(...dp[N]))