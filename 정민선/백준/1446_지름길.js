// ??? 사실 이해가 다 되진않았음....ㅎ
const fs = require('fs');
let input = fs.readFileSync('dev/stdin').toString().trim().split("\n");

let [n, d] = input[0].split(" ").map(Number);
let road = Array(d + 1).fill(Infinity);
let shortcuts = [];
road[0] = 0;

for (let i = 1; i <= n; i++) {
    let [start, end, length] = input[i].split(" ").map(Number);
    if (end <= d) {
        shortcuts.push([start, end, length]);
    }
}

let pqueue = [[0, 0]];

while (pqueue.length > 0) {
    let minIndex = 0;
    for (let i = 1; i < pqueue.length; i++) {
        if (pqueue[i][1] < pqueue[minIndex][1]) {
            minIndex = i;
        }
    }
    let [pos, dist] = pqueue.splice(minIndex, 1)[0];

    if (dist > road[pos]) continue;

    if (pos + 1 <= d) {
        let newDistance = dist + 1;
        if (newDistance < road[pos + 1]) {
            road[pos + 1] = newDistance;
            pqueue.push([pos + 1, newDistance]);
        }
    }

    for (let [start, end, length] of shortcuts) {
        if (start === pos) {
            let newDistance = dist + length;
            if (newDistance < road[end]) {
                road[end] = newDistance;
                pqueue.push([end, newDistance]);
            }
        }
    }
}

console.log(road[d]);
