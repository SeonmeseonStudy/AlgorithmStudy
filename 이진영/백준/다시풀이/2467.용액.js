const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

const N = +input[0];
const arr = input[1].trim().split(" ").map(Number);

let l = 0;
let r = N - 1;
let absSum = Math.abs(arr[l] + arr[r]);

let answer = [arr[l], arr[r]];

while (l < r) {
    const sum = arr[l] + arr[r];

    if (sum === 0) {
        answer = [arr[l], arr[r]];
        break;
    }

    if (absSum > Math.abs(sum)) {
        absSum = Math.abs(sum);
        answer = [arr[l], arr[r]];
    }

    if (sum < 0) {
        l++;
    } else {
        r--;
    }
}

console.log(answer.join(" "));