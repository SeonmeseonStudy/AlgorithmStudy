var input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

var [m, n] = input[0].split(" ").map(Number);
var board = input.slice(1).map(v => v.split(" ").map(Number));

var tetros = [
    [[1, 1, 1, 1]], [[1], [1], [1], [1]],
    [[1, 1], [1, 1]],
    [[1, 0], [1, 0], [1, 1]], [[0, 1], [0, 1], [1, 1]], [[1, 1], [1, 0], [1, 0]], [[1, 1], [0, 1], [0, 1]],
    [[1, 1, 1], [1, 0, 0]], [[1, 1, 1], [0, 0, 1]], [[1, 0, 0], [1, 1, 1]], [[0, 0, 1], [1, 1, 1]],
    [[1, 0], [1, 1], [0, 1]], [[0, 1], [1, 1], [1, 0]], [[0, 1, 1], [1, 1, 0]], [[1, 1, 0], [0, 1, 1]],
    [[1, 1, 1], [0, 1, 0]], [[0, 1, 0], [1, 1, 1]], [[0, 1], [1, 1], [0, 1]], [[1, 0], [1, 1], [1, 0]]
]

var max = 0;

for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
        for (let tetro of tetros) {
            if (m - i < tetro.length || n - j < tetro[0].length) continue;
            let sum = 0;
            for (let k = 0; k < tetro.length; k++) {
                for (let l = 0; l < tetro[0].length; l++) {
                    sum += board[i + k][j + l] * tetro[k][l];
                }
            }
            max = Math.max(max, sum);
        }
    }
}

console.log(max);