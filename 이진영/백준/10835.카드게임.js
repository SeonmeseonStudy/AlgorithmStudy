// 검색 풀이

var input = require('fs').readFileSync("dev/stdin").toString().trim().split("\n");
var N = +input[0].trim();
var left = input[1].trim().split(" ").map(Number);
var right = input[2].trim().split(" ").map(Number);

var dp = Array.from({ length: N }, () => Array(N).fill(-1));

var f = function (l, r) {
    if (l === N || r === N) return 0;
    if (dp[l][r] !== -1) return dp[l][r];

    dp[l][r] = Math.max(f(l+1, r+1), f(l+1, r));

    if (left[l] > right[r]) {
        dp[l][r] = Math.max(dp[l][r], f(l, r+1) + right[r]);
    }
    return dp[l][r];
}

console.log(f(0, 0));