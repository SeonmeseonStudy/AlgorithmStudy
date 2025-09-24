const input = require('fs').readFileSync('dev/stdin').toString().split("\n");

const [n, d, k, c] = input[0].split(" ").map(v => +v.trim());
const sushis = input.slice(1).map(v => +v.trim());

let cnt = 1;
let count = Array(d + 1).fill(0);
count[c] = 1;

for (let i = 0; i < k; i++) {
    if (count[sushis[i]] === 0) cnt++;
    count[sushis[i]]++;
}

let answer = cnt;

for (let i = 0; i < n - 1; i++) {
    count[sushis[i]]--;
    if (count[sushis[i]] === 0) cnt--;
    const newIdx = i < n - k ? i + k : i + k - n;
    if (count[sushis[newIdx]] === 0) cnt++;
    count[sushis[newIdx]]++;
    answer = Math.max(answer, cnt);
}

console.log(answer);