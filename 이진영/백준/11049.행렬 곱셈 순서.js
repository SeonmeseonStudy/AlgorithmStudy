const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const n = +input[0];
const arrays = input.slice(1).map(line => line.split(' ').map(Number));

const dp = Array.from({ length: n }, () => Array(n).fill(Number.MAX_SAFE_INTEGER));

for (let i = 0; i < n; i++) dp[i][i] = 0;

for (let len = 2; len <= n; len++) {
  for (let i = 0; i <= n - len; i++) {
    const j = i + len - 1;
    for (let k = i; k < j; k++) {
      const cost = dp[i][k] + dp[k + 1][j] + arrays[i][0] * arrays[k][1] * arrays[j][1];
      if (cost < dp[i][j]) dp[i][j] = cost;
    }
  }
}

console.log(dp[0][n - 1]);
