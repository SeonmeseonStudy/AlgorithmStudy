const input = require('fs').readFileSync('dev/stdin').toString().split("\n");

const N = +input[0];
const before = input[1].split("").map(Number);
const after = input[2].split("").map(Number);

const beforeSwitched = [...before];
beforeSwitched[0] = 1 - beforeSwitched[0];
beforeSwitched[1] = 1 - beforeSwitched[1];

const count = [0, 1]

for (let i = 1; i < N; i++) {
    if (after[i - 1] !== before[i - 1]) {
        toggle(before, i);
        count[0]++;
    }
    if (after[i - 1] !== beforeSwitched[i - 1]) {
        toggle(beforeSwitched, i);
        count[1]++;
    }
}

const answer = Math.min(
    after[N - 1] !== before[N - 1] ? Infinity : count[0],
    after[N - 1] !== beforeSwitched[N - 1] ? Infinity : count[1]
)
console.log(answer === Infinity ? -1 : answer);

function toggle(arr, idx) {
    arr[idx - 1] = 1 - arr[idx - 1];
    arr[idx] =  1 - arr[idx];
    arr[idx + 1] = 1 - arr[idx + 1];
}