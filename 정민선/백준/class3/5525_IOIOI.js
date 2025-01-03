const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
const M = Number(input.shift());
const S = input.shift();

let PN = '';
for (let i=0; i<N; i++){
    PN += 'IO';
}
PN += 'I';

let count = 0;
let P = PN.length;
let start = S.indexOf('I');
while (start <= M - P) {
    if (S.slice(start, start + P) === PN) {
        count++;
        start += 2;
    } else {
        start++;
    }
}

console.log(count);