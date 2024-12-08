const fs = require("fs");
let [n, k] = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split(' ').map(Number);
let visited = Array(100001).fill(false);
let queue = [];
queue.push([n, 0]); // 현재위치, 횟수

while (queue.length > 0) {
    let [position, count] = queue.shift();

    if (position === k) {
        console.log(count);
        break
    }
    visited[position] = true;
    if (position*2 < 100001 && !visited[position*2]) {
        queue.unshift([position*2, count])
    }
    if (position + 1 < 100001 && !visited[position+1]) {
        queue.push([position+1, count+1])
    }
    if (position - 1 >= 0 && !visited[position-1]) {
        queue.push([position-1, count+1])
    }
}