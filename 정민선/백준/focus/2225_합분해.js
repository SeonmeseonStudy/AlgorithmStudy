const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
const [N, K] = input.split(' ').map(Number);
const MOD = 1000000000;

let dp = Array.from({length : K+1}, () => Array(N+1).fill(0));

for (let i = 0; i <= N; i++) dp[1][i] = 1;
// i개 숫자를 사용해 j가 되는 경우의 수

for(let i=2; i<=K; i++) {
    for (let j=0; j<=N; j++) {
        if (j === 0) dp[i][j] = dp[i-1][j] % MOD;
        else dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
    }
}

console.log(dp[K][N])
// let count = 0;
// function backtrack(sum, number) {
//     if (number === K) {
//         if (sum === N) count = (count + 1) % 1000000000;
//         return
//     }

//     for (let i=0; i<=N; i++) {
//         backtrack(sum+i, number+1);
//     }
// }

// backtrack(0, 0);