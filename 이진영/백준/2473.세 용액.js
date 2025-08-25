const input = require('fs').readFileSync('dev/stdin').toString().trim().split('\n');
const n = +input[0];
const arr = input[1].split(' ').map(Number).sort((a, b) => a - b);

let output = [];
let min = Infinity;

function solution() {
    let result = [];

    for (let i = 0; i < n - 2; i++) {
        let l = i + 1;
        let r = n - 1;

        while (l < r) {
            const sum = arr[i] + arr[l] + arr[r];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                result = [arr[i], arr[l], arr[r]];
            }

            if (sum > 0) r -= 1;
            else l += 1;
        }
    }

    return result;
}

console.log(solution().join(' '));