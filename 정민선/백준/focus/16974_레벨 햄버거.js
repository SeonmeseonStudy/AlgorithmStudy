const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim();
const [N, X] = input.split(' ').map(Number);
let patty = Array(N+1).fill(1);

for (let i=1; i<=N; i++) {
    patty[i] = (patty[i-1] * 2) + 1;
}

function countP(n, x) {
    if (n === 0) return x > 0? 1: 0;

    if (x === patty[n]) return patty[n-1]+1;
    if (x > patty[n]) return patty[n-1]+1+countP(n-1, x-patty[n]);
    else return countP(n-1, x-1);
}

console.log(countP(N, X))