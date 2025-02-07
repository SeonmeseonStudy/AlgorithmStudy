const fs = require('fs');
const { dlopen } = require('process');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let lines = input.map(e => e.split(' ').map(Number));
lines.sort((a,b) => a[0] - b[0]);

let checkLine = lines.map(line => line[1]);
let dp = Array(N).fill(1);

for (let i=0; i<N; i++) {
    for (let j=0; j<i; j++) {
        if (checkLine[j] < checkLine[i]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
}
console.log(N - Math.max(...dp));
