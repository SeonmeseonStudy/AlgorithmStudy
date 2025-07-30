const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

const [N, K] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);
const robot = Array(2 * N).fill(false);

let up = 0;
let down = N - 1;

let noDur = 0;

let step = 0;

function rotate(num) {
    return (num - 1 + 2 * N) % (2 * N);
}

while (noDur < K) {
    // 1
    step++;
    up = rotate(up);
    down = rotate(down);

    if (robot[down]) robot[down] = false;

    // 2
    for (let i = down; i !== up; i = rotate(i)) {
        const prev = rotate(i);
        if (!robot[i] && robot[prev] && arr[i] > 0) {
            robot[prev] = false;
            robot[i] = true;
            arr[i]--;
            if (arr[i] === 0) noDur++;
        }
    }

    if (robot[down]) robot[down] = false;

    // 3
    if (!robot[up] && arr[up] > 0) {
        robot[up] = true;
        arr[up]--;
        if (arr[up] === 0) noDur++;
    }
}

console.log(step);