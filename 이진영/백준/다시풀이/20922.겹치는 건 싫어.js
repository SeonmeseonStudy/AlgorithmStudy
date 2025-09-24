const input = require('fs').readFileSync('dev/stdin').toString().split("\n");

const [n, k] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

let count = new Map();

let l = 0, r = 0;
let max = 0;

while (l < n) {
    while (r < n) {
        const num = arr[r];
        if (!count.has(num) || count.get(num) < k) {
            increaseCount(num);
            r++;
        }
        else break;
    }

    max = Math.max(max, r - l);
    decreaseCount(arr[l]);
    l++;
}

console.log(max);

function increaseCount(num) {
    if (count.has(num)) {
        count.set(num, count.get(num) + 1);
    }
    else {
        count.set(num, 1);
    }
}

function decreaseCount(num) {
    if (count.has(num)) {
        count.set(num, count.get(num) - 1);
    }
}