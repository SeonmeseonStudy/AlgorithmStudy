const fs = require('fs');
let input = fs.readFileSync('./정민선/백준/input.txt').toString().trim().split('\n'); // 0, 'utf-8'
const [N, M, K] = input.shift().split(' ').map(Number);
let board = Array.from({length: M}, () => Array(N).fill(1));

for (let data of input) {
    let [x, y, x2, y2] = data.split(' ').map(Number);

    for (let i=x; i<x2; i++) {
        for (let j=y; j<y2; j++) {
            board[i][j] = 0;
        }
    }
}

function dfs(x, y) {
    let queue = [[x, y]];
    let size = 1;

    while(queue.length > 0) {
        let [cx, cy] = queue.pop();
        for (let d=0; d<4; d++) {
            let nx = cx+dxs[d];
            let ny = cy+dys[d];

            if (0 <= nx && nx < M && 0 <= ny && ny < N &&
                !visited[nx][ny] && board[nx][ny] === 1) {
                visited[nx][ny] = true;
                size++;
                queue.push([nx, ny]);
            }
        }
    }
    return result.push(size);
}

let dxs = [0, 1, 0, -1], dys = [1, 0, -1, 0];
let visited = Array.from({length: M}, () => Array(N).fill(false));
let result = [];
for(let i=0; i<M; i++) {
    for (let j=0; j<N; j++) {
        if (!visited[i][j] && board[i][j] === 1) {
            visited[i][j] = true;
            dfs(i, j);
        }
    }
}
result.sort((a, b) => a-b);
console.log(result.length);
console.log(result.join(' '));