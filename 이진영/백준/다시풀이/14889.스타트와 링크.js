var input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

var n = +input[0].trim();
var board = input.slice(1).map(v => v.split(" ").map(Number));
var visited = Array(n).fill(false);
var min = Infinity;

dfs(0, 0);
console.log(min);

function dfs(idx, num) {
    if (num === n / 2) {
        let a = [], b = [];
        for (let i = 0; i < n; i++) {
            if (visited[i]) a.push(i);
            else b.push(i);
        }
        let sumA = 0; sumB = 0;

        for (let i = 0; i < n / 2; i++) {
            for (let j = i + 1; j < n / 2; j++) {
                sumA += board[a[i]][a[j]] + board[a[j]][a[i]];
                sumB += board[b[i]][b[j]] + board[b[j]][b[i]];
            }
        }
        min = Math.min(Math.abs(sumA - sumB), min);
        return;
    }

    for (let i = idx + 1; i < n; i++) {
        visited[i] = true;
        dfs(i, num + 1);
        visited[i] = false;
    }
}