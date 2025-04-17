var input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

var n = +input[0].trim();
var a = input[1].trim().split(" ").map(Number);
var [b, c] = input[2].trim().split(" ").map(Number);

console.log(a.reduce((p, n) => p + 1 + (n < b ? 0 : Math.ceil((n - b) / c)), 0));