const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let numbers = input.shift().split(' ').map(Number);
let dp = Array(N).fill(1);

for (let i=0; i<N; i++){
    for (let j = 0; j < i; j++) {
        if (numbers[i] > numbers[j]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
}

console.log(Math.max(...dp));