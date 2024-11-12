const fs = require("fs");
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n').map(Number);
let dp = Array(10001).fill(0).map(() => Array(4).fill(0));

dp[0][1] = 1;
dp[0][2] = 0;
dp[0][3] = 0;
let maxValue = Math.max(...input)+1;

for (let i = 1; i < maxValue; i++) {
    if (i >= 1) {
        dp[i][1] = dp[i - 1][1];
    }
    if (i >= 2) {
        dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
    }
    if (i >= 3) {
        dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
    }
}

for (let i = 1; i < input.length; i++) {
    let [x, a, b, c] = dp[input[i]]
    console.log(a+b+c);
}

// 대박이다..! dp(num - 3) + Math.floor(num / 2) + 1;
