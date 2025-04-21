var input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");
var [[n], a, operNum] = input.map(v => v.split(" ").map(Number));
var opers = [
    (a, b) => a + b, 
    (a, b) => a - b,
    (a, b) => a * b,
    (a, b) => {
        var minus = 1;
        var ra = a;
        var rb = b;
        if (a < 0) {
            ra *= -1;
            minus *= -1;
        }
        if (b < 0) {
            rb *= -1;
            minus *= -1;
        }
        return Math.floor(ra / rb) * minus;
    }
]
var max = -Infinity;
var min = Infinity;

dfs(0, a[0]);

console.log(max + "\n" + min);

function dfs(used, result) {
    if (used === n - 1) {
        max = Math.max(max, result);
        min = Math.min(min, result);
        return;
    }

    for (let i = 0; i < 4; i++) {
        if (operNum[i] > 0) {
            operNum[i]--;
            dfs(used + 1, opers[i](result, a[used + 1]));
            operNum[i]++;
        }
    }
}
