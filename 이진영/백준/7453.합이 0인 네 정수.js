const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

const n = Number(input[0]);
const arrs = input.slice(1).map(line => line.split(" ").map(Number));

const ab = new Map();

for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
        const sum = arrs[i][0] + arrs[j][1];
        ab.set(sum, (ab.get(sum) || 0) + 1);
    }
}

let ans = 0;

for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
        const sum = -(arrs[i][2] + arrs[j][3]);
        if (ab.has(sum)) {
            ans += ab.get(sum);
        }
    }
}
console.log(ans);
