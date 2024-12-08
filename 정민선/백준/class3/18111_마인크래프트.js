const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const [N, M, B] = input[0].split(' ').map(Number);
let board = input.slice(1).map(e => e.split(' ').map(Number));
let minTime = Infinity;
let height = 0;

let left = Math.min(...board.flat());
let right = 256;

for (let mid=right; mid>=left; mid--) {
    let removeTime = 0;
    let addTime = 0;
    let blocks = B;
    
    for (let i = 0; i < N; i++) {
        for (let j = 0; j < M; j++) {
            const diff = board[i][j] - mid;
            if (diff > 0) {
                removeTime += diff * 2;
                blocks += diff;
            } else if (diff < 0) {
                addTime += Math.abs(diff);
                blocks -= Math.abs(diff);
            }
        }
    }

    if (blocks < 0) {
        right = mid - 1;
        continue;
    }
    const totalTime = removeTime + addTime;
    if (totalTime < minTime) {
        minTime = totalTime;
        height = mid;
    }
}

console.log(minTime, height);