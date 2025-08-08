const [N, K, P, X] = require('fs').readFileSync('dev/stdin').toString().split(" ").map(Number);
const display = [
    [1, 1, 1, 0, 1, 1, 1],
    [0, 0, 1, 0, 0, 1, 0],
    [1, 0, 1, 1, 1, 0, 1],
    [1, 0, 1, 1, 0, 1, 1],
    [0, 1, 1, 1, 0, 1, 0],
    [1, 1, 0, 1, 0, 1, 1],
    [1, 1, 0, 1, 1, 1, 1],
    [1, 0, 1, 0, 0, 1, 0],
    [1, 1, 1, 1, 1, 1, 1],
    [1, 1, 1, 1, 0, 1, 1]
];

const inverse = Array.from(Array(10), () => Array(10).fill(0));

for (let i = 0; i < 10; i++) {
    for (let j = i + 1; j < 10; j++) {
        inverse[i][j] = display[i].reduce((p, n, idx) => n !== display[j][idx] ? p + 1 : p, 0);
        inverse[j][i] = inverse[i][j];
    }
}

const X_ = X.toString().padStart(K, '0').split("").map(Number);
let answer = 0;
dfs(0, 0, 0)
console.log(answer);

function dfs(idx, num, accum) {
    if (idx < K) {
        for (let i = 0; i < 10; i++) {
            const new_accum = accum + inverse[X_[idx]][i];
            const new_num = num * 10 + i;
            if (new_accum <= P && new_num * (10 ** (K - 1 - idx)) <= N) {
                dfs(idx + 1, new_num, new_accum);
            }
        }
    } else {
        if (num > 0 && num <= N && accum > 0 && accum <= P) answer++;
    }
}