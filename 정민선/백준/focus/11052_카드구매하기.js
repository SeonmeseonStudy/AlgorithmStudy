const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let numbers = [0, ...input.shift().split(' ').map(Number)];

let dp = Array(N+1).fill(0);
dp[0] = 0;

for (let i=1; i<N+1; i++){
    for (let j=1; j<=i; j++) {
        dp[i] = Math.max(dp[i], dp[i-j]+numbers[j]);
    }
}
console.log(dp[N]);