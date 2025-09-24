const input = require('fs').readFileSync('dev/stdin').toString().split("\n");

const [C, N] = input[0].split(" ").map(Number);
const costCust = input.slice(1).map(v => v.trim().split(" ").map(Number));
const MAX = C + 100;

const dp = Array(MAX).fill(Infinity);
dp[0] = 0;

for (let i = 0; i < N; i++) {
    const [cost, cust] = costCust[i];
    for (let j = cust; j < MAX; j++) {
        dp[j] = Math.min(dp[j], dp[j - cust] + cost);
    }
}

console.log(Math.min(...dp.slice(C)));