const input = require('fs').readFileSync('dev/stdin').toString().split("\n");
const N = +input[0];
const arr = input.map(Number);
arr[0] = null;

let answer = new Set();

for (let i = 1; i <= N; i++) {
    if (answer.has(i)) continue;

    let cur = i;
    let q = [i];

    while (q.length < N) {
        const next = arr[cur];

        if (answer.has(next)) {
            break;
        }

        q.push(next);
        if (q[0] === arr[next]) {
            q.forEach(v => {
                answer.add(v);
            })
            break;
        } else {
            cur = next;
        }
    }
}

console.log(answer.size);
console.log([...answer].sort((a, b) => a - b).join("\n"))