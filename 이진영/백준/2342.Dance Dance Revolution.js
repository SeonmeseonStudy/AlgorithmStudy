const input = require('fs').readFileSync('dev/stdin').toString().trim().split(" ").map(Number);
input.pop(); // 마지막 0 제거
input.unshift(0); // 시작 위치 0 추가
const l = input.length;

const calculatePower = (from, to) => {
    if (from === to) return 1;
    if (from === 0 || to === 0) return 2;
    if (Math.abs(from - to) === 1 || Math.abs(from - to) === 3) return 3;
    if (Math.abs(from - to) === 2) return 4; 
};

const INF = Infinity;
const dp = Array.from({ length: 5 }, () => Array.from({ length: 5 }, () => Array(l).fill(INF)));

dp[0][0][0] = 0;

for (let idx = 1; idx < l; idx++) {
    let op = input[idx];
    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            if (dp[i][j][idx - 1] !== INF) {
                dp[i][op][idx] = Math.min(dp[i][op][idx], dp[i][j][idx - 1] + calculatePower(j, op));
                dp[op][j][idx] = Math.min(dp[op][j][idx], dp[i][j][idx - 1] + calculatePower(i, op));
            }
        }
    }
}

let last = input[l - 1];
let answer = INF;
for (let i = 0; i < 5; i++) {
    answer = Math.min(answer, dp[i][last][l - 1], dp[last][i][l - 1]);
}
console.log(answer);
