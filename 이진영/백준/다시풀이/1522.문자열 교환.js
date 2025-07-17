const input = require('fs').readFileSync('dev/stdin').toString().trim().split("");

const str = [...input, ...input];

const aCnt = input.reduce((p, n) => n === 'a' ? p + 1 : p, 0);
let bCnt_sliding = input.slice(0, aCnt).reduce((p, n) => n === 'b' ? p + 1 : p, 0);

let min = bCnt_sliding;

for (let i = 1; i < str.length - aCnt + 1; i++) {
    if (str[i - 1] === 'b') bCnt_sliding--;
    if (str[i + aCnt - 1] === 'b') bCnt_sliding++;

    min = Math.min(min, bCnt_sliding);
}

console.log(min);