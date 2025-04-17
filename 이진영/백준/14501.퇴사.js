var input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

var n = +input[0].trim();
var tps = input.slice(1).map(v => v.trim().split(' ').map(Number));
var answer = 0;
dfs(0, 0);
console.log(answer);

function dfs(idx, p) {
    if (idx >= n) {
        answer = Math.max(answer, p);
        return;
    }

    dfs(idx + 1, p);
    if (idx + tps[idx][0] - 1 < n) dfs(idx + tps[idx][0], p + tps[idx][1]);
}