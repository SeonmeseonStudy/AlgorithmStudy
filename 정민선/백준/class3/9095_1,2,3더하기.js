const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let T = Number(input.shift());
let dp = Array(11).fill(0);
dp[0] = 1;
dp[1] = 1;
dp[2] = 2;

for (let i=3; i<11; i++){
    dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
}

for (let N of input){
    console.log(dp[N]);
}