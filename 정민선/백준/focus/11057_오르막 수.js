const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
const N = Number(input);

let dp = Array.from({length : 1001}, () => Array(10).fill(0));

// 초깃값
for (let i=0; i<10; i++) {
    dp[1][i] = 1;
}

for (let i=2; i<=N; i++) {
    for (let j=0; j<10; j++) {
        dp[i][j] = [...dp[i-1].slice(j)].reduce((a, b) => (a+b))%10007;;
    }
}
console.log(dp[N].reduce((a, b) => (a+b))%10007);