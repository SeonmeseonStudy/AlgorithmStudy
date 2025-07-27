const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n");

const START = 1;
const GOAL = 100;
const DICE = 6;
const arrs = input.slice(1).map(v => v.split(" ").map(Number));

const map = new Map();
arrs.forEach(([start, end]) => {
    map.set(start, end);
})

const dp = Array(GOAL + 1).fill(Infinity);
dp[START] = 0;

const q = [[START, dp[START]]];

while (q.length) {
    const [block, count] = q.shift();

    // // 끝 이상으로 도달하면 끝에 더 작은 값 저장
    // if (block >= GOAL) {
    //     dp[GOAL] = Math.min(dp[GOAL], count);
    //     continue;
    // }

    for (let i = 1; i <= DICE; i++) {
        const next = block + i;
        
        if (map.has(next) && dp[next] > count + 1) {
            dp[next] = count + 1;
            q.push([map.get(next), count + 1]);
        } else if (dp[next] > count + 1) {
            dp[next] = count + 1;
            q.push([next, count + 1]);
        }
    }
}

console.log(dp[GOAL]);