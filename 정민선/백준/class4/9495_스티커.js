const fs = require('fs');
let input = fs.readFileSync('정민선/백준/input.txt').toString().trim().split('\n');
const T = Number(input.shift());

for (let i=0; i<T; i++){
    let N = Number(input.shift());
    let sticker = [];
    sticker.push(input.shift().split(' ').map(Number));
    sticker.push(input.shift().split(' ').map(Number));

    let dp = Array.from({length : N}, () => Array(3).fill(0));
    dp[0][0] = sticker[0][0];
    dp[0][1] = sticker[1][0];
    dp[0][2] = 0;

    for (let j=1; j<N; j++) {
        dp[j][0] = sticker[0][j] + Math.max(dp[j-1][1], dp[j-1][2]);
        dp[j][1] = sticker[1][j] + Math.max(dp[j-1][0], dp[j-1][2])
        dp[j][2] = Math.max(dp[j-1][0], dp[j-1][1], dp[j-1][2])
    }

    console.log(Math.max(dp[N-1][0], dp[N-1][1], dp[N-1][2]))
}