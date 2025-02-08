const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n');
const N = Number(input.shift());
let board = input.map(e => e.split(' ').map(Number));
let heightsSet = new Set(board.flat());
let heights = [...heightsSet];

const length = heights.length;
let result = 1;

function inrange(x, y) {
    return 0 <= x && x < N && 0 <= y && y < N;
}

function bfs(nx, ny, k, visited) {
    let dxs = [0, 1, 0, -1], dys = [1, 0, -1, 0];
    let queue = [[nx, ny]];

    while (queue.length > 0) {
        let [x, y] = queue.shift();
        for (let d=0; d<4; d++){
            let dx = x+dxs[d], dy = y+dys[d];
            if (inrange(dx, dy) && !visited[dx][dy] && board[dx][dy] > k) {
                visited[dx][dy] = true;
                queue.push([dx, dy]);
            }
        }
    }
    return 0;
}


for (let i=0; i<length; i++) {
    let height = heights[i];
    let visited = Array.from({length : N}, () => Array(N).fill(false));
    let count = 0;
    for (let i=0; i<N; i++) {
        for (let j=0; j<N; j++) {
            if (!visited[i][j] && board[i][j] > height) {
                bfs(i, j, height, visited);
                count++;
            }
        }
    }
    result = Math.max(result, count);
}

console.log(result);