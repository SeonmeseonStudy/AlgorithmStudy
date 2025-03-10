const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
let [N, T] = input.shift().split(' ').map(Number);
let dp = Array(T+1).fill(0);

let total = 0;
for (let data of input){
    let [test, score] = data.split(' ').map(Number);
    total += score;
    for (let i=T; i>=test; i--) {
        dp[i] = Math.max(dp[i], dp[i-test] + score);
    }
}

console.log(total !== dp[T] ? total-dp[T] : 0);