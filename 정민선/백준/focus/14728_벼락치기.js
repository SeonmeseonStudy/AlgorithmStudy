const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split("\n");
const [N, T] = input.shift().split(' ').map(Number);

let dp = Array(T+1).fill(0);

for (let i=0; i<N; i++) {
    let [time, score] = input[i].split(' ').map(Number);
    for (let t = T; t>=time; t--) {
        dp[t] = Math.max(dp[t], dp[t-time] + score);
    }
}
console.log(dp[T]);