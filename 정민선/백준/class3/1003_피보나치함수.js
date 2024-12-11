const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
let T = Number(input.shift());
let dp = Array.from({length:41}, () => [0,0]);
dp[0] = [1, 0];
dp[1] = [0, 1];

for (let i=2; i<= 40; i++){
    dp[i][0] = dp[i-1][0] + dp[i-2][0];
    dp[i][1] = dp[i-1][1] + dp[i-2][1];
}

for (let n of input){
    console.log(dp[n].join(' '));
}