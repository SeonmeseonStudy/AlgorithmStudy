const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');

const N = Number(input[0]);
let map = input.slice(1).map(e => e.split('').map(Number));
let visited = Array(N).fill(0).map(e => Array(N).fill(false));

function inrange(x, y){
    return x >= 0 && y >= 0 && x < N && y < N;
}

function bfs(i, j){
    let queue = [[i, j]];
    visited[i][j] = true;
    let [dxs, dys] = [[0, 1, 0, -1], [1, 0, -1, 0]];
    let count = 1;

    while (queue.length > 0) {
        let [x, y] = queue.shift();

        for (let k = 0; k < 4; k++) {
            let nx = x + dxs[k];
            let ny = y + dys[k];

            if (inrange(nx, ny) && !visited[nx][ny] && map[nx][ny] === 1) {
                visited[nx][ny] = true;
                queue.push([nx, ny]);
                count++;
            }
        }
    }
    return count
}

let result = []
for (let i=0; i<N; i++){
    for (let j=0; j<N; j++){
        if (!visited[i][j] && map[i][j] === 1) {
            result.push(bfs(i, j));
        }
    }
}

console.log(result.length);
result.sort((a, b) => a-b);
for (let r of result) {
    console.log(r)
}